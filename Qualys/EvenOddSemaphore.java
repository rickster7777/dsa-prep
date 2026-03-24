/*

can we print even/odd printing Just semaphores not threads platform or virtual possible ?
Yes — you can implement coordination purely with semaphores, without worrying about “threads” at all in the API sense. But you need something executing the code — otherwise nothing runs. Let me explain clearly.

🧠 1. Semaphores are not threads
A semaphore is just a synchronization primitive — it controls access to resources or order of execution.
It does not execute any code by itself.
To actually print numbers or perform actions, you need some execution context, which could be:
Platform threads (Thread)
Virtual threads (Thread.startVirtualThread)
Thread pools (ExecutorService)
Coroutines / tasks in other systems


🏁 TL;DR
Semaphores = coordination / signaling ✅
Threads (platform or virtual) = execution ✅
Semaphores alone cannot replace threads in Java ❌

Key takeaway (senior-level phrasing)

“Semaphores can fully control the alternation between operations, but in Java you still need an execution context — either a thread, virtual thread, or executor. Semaphores alone cannot run code; they only enforce ordering or resource access.”
*/

import java.util.concurrent.Semaphore;

public class EvenOddSemaphore {

    private int num = 1;
    private final int max;

    private final Semaphore odd = new Semaphore(1);   // odd starts first
    private final Semaphore even = new Semaphore(0);  // even waits

    public EvenOddSemaphore(int max) {
        this.max = max;
    }

    public void printOdd() {
        while (true) {
            try {
                odd.acquire();

                if (num > max) {
                    even.release(); // allow other thread to exit
                    break;
                }

                System.out.println("Odd: " + num);
                num++;

                even.release();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void printEven() {
        while (true) {
            try {
                even.acquire();

                if (num > max) {
                    odd.release(); // allow other thread to exit
                    break;
                }

                System.out.println("Even: " + num);
                num++;

                odd.release();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        EvenOddSemaphore printer = new EvenOddSemaphore(10);

        // Works with platform threads
        // new Thread(printer::printOdd).start();
        // new Thread(printer::printEven).start();

        // ✅ Or with virtual threads
        Thread.startVirtualThread(printer::printOdd);
        Thread.startVirtualThread(printer::printEven);
    }
}
