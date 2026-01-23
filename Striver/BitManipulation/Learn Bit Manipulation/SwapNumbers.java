public class SwapNumbers {
    public static void main(String[] args) {

        int a = 10, b = 5;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // 1️⃣ Using String Concatenation (Most Common)
        System.out.println(a + " " + b);


        // 2️⃣ Using printf() (Interview-friendly)
        System.out.printf("%d %d%n", a, b);


        // 3️⃣ Using String.format()
        System.out.println(String.format("%d %d", a, b));

    }
}
/*
1️⃣ Why & How XOR Swapping Works
XOR Properties Used

x ^ x = 0
x ^ 0 = x

XOR is commutative & associative

Step-by-step with values
int a = 10; // 1010
int b = 5;  // 0101

Step 1
a = a ^ b;   // 1010 ^ 0101 = 1111 (15)

Now:
a = 15
b = 5

Step 2
b = a ^ b;   // 1111 ^ 0101 = 1010 (10)

Now:
a = 15
b = 10

Step 3
a = a ^ b;   // 1111 ^ 1010 = 0101 (5)

Now:
a = 5
b = 10

✅ Values are swapped without extra memory

3️⃣ Can You Use XOR Swap in Sorting Algorithms?
🚫 Short Answer: NO (Don’t use it)
❌ Reasons

1️⃣ Fails when a and b refer to the same memory
swap(arr[i], arr[i]); // a ^ a = 0 → value lost

2️⃣ Slower on modern CPUs
Temporary variable is optimized by compiler
XOR swap causes data dependency stalls

3️⃣ Harder to read & debug
Interviewers prefer clarity over cleverness

4️⃣ Correct Way in Sorting Algorithms
✅ Use Temporary Variable
int temp = a;
a = b;
b = temp;

Why this is better

✔ Safe
✔ Readable
✔ Compiler-optimized
✔ Works when indices are same


6️⃣ Interview Verdict on XOR Swap
Use it to explain bit manipulation knowledge, not in production code.

What interviewers like to hear:
“XOR swap works due to XOR properties, but I wouldn’t use it in sorting algorithms because it’s unsafe for same indices and less readable.”

⭐ Bonus Trick Question
Q: When is XOR swap useful?
A: Almost never in modern code — only as a theoretical concept.
*/

/*
Show why compiler optimizes temp-variable swap
🔹 Summary: Why temp-variable swap is better than XOR swap

Compilers optimize temp swaps:
The temporary variable is usually kept in CPU registers, not memory.

No extra memory cost:
temp often doesn’t exist after compilation.

Faster execution:
Temp swap can become just a few mov instructions or even a single xchg.

XOR swap is slower:
It creates instruction dependencies that block CPU parallelism.

XOR swap is unsafe:
Fails when both variables refer to the same memory location.

Readability matters:
Temp swap is clear and preferred in interviews and production code.

⭐ Interview one-liner

“Modern compilers optimize away the temporary variable, making it faster and safer than XOR swap.”


| Swap Method      | Safety     | Readability | Performance |
| ---------------- | ---------- | ----------- | ----------- |
| Temp variable    | ✅          | ⭐⭐⭐⭐⭐       | ⭐⭐⭐⭐⭐       |
| XOR swap         | ❌          | ⭐⭐          | ⭐⭐          |
| Arithmetic (+ -) | ❌ overflow | ⭐⭐          | ⭐⭐          |

*/
