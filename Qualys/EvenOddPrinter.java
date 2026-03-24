public class EvenOddPrinter {

    private int num = 1;
    private final int max;


    public EvenOddPrinter(int max){
        this.max = max;
    }

    public synchronized void printOdd(){
        while (num <= max) {

            while (num % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(num);
            num++;
            notify();
        }
    }

    public synchronized void printEven(){
        while (num <= max) {

            while (num % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(num);
            num++;
            notify();
        }
    }


    public synchronized void printMultipleOf3() {
        while (num <= max) {

            while (num <= max && num % 3 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (num <= max) {
                System.out.println("Multiple of 3: " + num);
                num++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args){

        EvenOddPrinter printer = new EvenOddPrinter(10);

        Thread T1 = new Thread(() -> printer.printOdd());
        T1.start();

        Thread T2 = new Thread(() -> printer.printEven());
        T2.start();

        /*
        In case of virtual threads the above part will be updated like this 

        Thread.startVirtualThread(() -> printer.printOdd());
        Thread.startVirtualThread(() -> printer.printEven());
        */
        //If another thread printing multiplier of 3 is needed.
        Thread T3 = new Thread(() -> printer.printMultipleOf3());
        T2.start();

    }
}
/*
🔑 Explanation (Senior-Level Answer)
Every Java object has an intrinsic lock (monitor)
When you use synchronized, you lock the object, not the thread
wait() / notify() operate on that object’s monitor
👉 What actually happens:
synchronized (obj) {
    obj.wait();
}
Thread acquires obj's lock
Calls wait() → releases obj’s lock
Goes into WAITING state
Another thread calls notify() on same obj
Waiting thread competes again for obj’s lock
❗ Why not Thread methods?

If these were in Thread, it would break the model because:

Coordination happens via shared resources (objects)
Not via threads themselves

👉 Threads don’t own locks — objects do

🎯 Golden Line for Interview

“In Java, inter-thread communication is based on object monitors. Threads coordinate by waiting on and notifying the monitor of a shared object, which is why wait() and notify() are defined on Object rather than Thread.”

🔥 Follow-Up Questions (with Answers)
1️⃣ Why must wait() be called inside synchronized block?
✅ Answer:

Because the thread must own the object's monitor before calling wait(), otherwise:

IllegalMonitorStateException

👉 Reason:

wait() releases the lock
JVM must ensure thread actually owns it before releasing
2️⃣ Difference between wait() and sleep()?
Feature	wait()	sleep()
Class	Object	Thread
Lock release	✅ Yes	❌ No
Used for	Communication	Delay
Needs synchronized	✅ Yes	❌ No

👉 Strong answer:

wait() is for coordination and releases the lock, while sleep() is just a pause and does not release any locks.

3️⃣ Why use while instead of if around wait()?
✅ Answer:

To handle:

Spurious wakeups
Wrong thread notification
while(condition not satisfied){
    wait();
}

👉 If you use if, thread may proceed incorrectly.

4️⃣ What are spurious wakeups?
✅ Answer:

A thread may wake up from wait() without notify/notifyAll

👉 Rare but allowed by JVM spec

👉 That’s why always:

while(condition) wait();
5️⃣ Difference between notify() and notifyAll()?
notify()	notifyAll()
Wakes one thread	Wakes all threads
Risk of deadlock	Safer
More efficient	More overhead

👉 Senior-level answer:

notify() is risky in complex systems due to missed signals, so notifyAll() is generally preferred unless you can guarantee correctness.

6️⃣ What happens after notify()?
✅ Answer:
Thread moves from WAITING → BLOCKED
It does NOT run immediately
It must re-acquire the lock
7️⃣ Can we call wait() on one object and notify() on another?
❌ Answer:

No — must be same object

👉 Otherwise waiting thread will never wake up

8️⃣ What is monitor in Java?
✅ Answer:

Monitor =

Mutex (lock) + condition variable (wait/notify mechanism)

Each object has:

Entry queue (blocked threads)
Wait set (waiting threads)
9️⃣ Why is notify() unsafe in your Even-Odd example?
✅ Answer:

Because:

It may wake the wrong thread
That thread will go back to waiting
No other thread gets notified → deadlock
🔟 Better alternative to wait/notify?
✅ Answer:

Use modern concurrency APIs:

ReentrantLock + Condition
BlockingQueue
Semaphore

👉 Senior-level line:

“wait/notify is low-level and error-prone; modern Java concurrency utilities provide better control and readability.”

1️⃣1️⃣ Difference: synchronized vs ReentrantLock
synchronized	ReentrantLock
Implicit	Explicit
No fairness	Can enable fairness
No interruptible lock	Supports interruptible
No multiple conditions	Multiple conditions
1️⃣2️⃣ What is thread starvation?
✅ Answer:

When a thread never gets CPU or lock due to others dominating

1️⃣3️⃣ What is deadlock in this context?
✅ Answer:

Two or more threads waiting indefinitely for each other’s locks

1️⃣4️⃣ Can notify wake a specific thread?
❌ Answer:

No — JVM decides

👉 That’s why Condition (ReentrantLock) is better

1️⃣5️⃣ What is happens-before relation here?
✅ Answer:
synchronized ensures visibility
Changes before notify() are visible after wait()
🧠 Final Interview Summary (What You Should Say)

If interviewer asks broadly:

“Thread communication in Java is based on object monitors. Threads synchronize on shared objects, and use wait() to release the lock and suspend execution, while notify()/notifyAll() wake waiting threads. These are object methods because the locking mechanism is tied to the object, not the thread itself.”
*/