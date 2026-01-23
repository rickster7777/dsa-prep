/*
The condition `i * i <= n` works in prime checking because of a key property of factors: if a number `n` has a divisor, it must have **at least one factor less than
or equal to √n**.

This is because factor pairs `a × b = n` always include one number ≤ √n; otherwise, their product would exceed `n`.

By checking only up to `i * i <= n`
instead of all numbers up to `n/2`, we efficiently test all possible divisors, avoid duplicate work, prevent floating-point operations, and significantly reduce time complexity from O(n) to O(√n). 

This concept is broadly useful in problems involving factors, perfect squares, and divisor-related optimizations.


This process is called
Optimized prime checking using integer square root” or simply “checking divisors up to √n using integer arithmetic
*/

class Solution {
    public boolean isPrime(int n) {

        // 0 and 1 are not prime numbers
        if (n <= 1) {
            return false;
        }

        // Check divisibility only up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {

            // If n is divisible by any number, it is not prime
            if (n % i == 0) {
                return false;
            }
        }

        // No divisors found
        return true;
    }
}


/*
now expalain this using two example for when n = 29 and n = 64

Sure! Let’s explain why i * i <= n works using the two examples: n = 29 (prime) and n = 64 (perfect square / composite).

Example 1: n = 29 (prime)
√29 ≈ 5.38 → we only need to check integers i = 2, 3, 4, 5
Using the loop:

i = 2 → 2*2 = 4 ≤ 29 → check 29 % 2 → not divisible
i = 3 → 3*3 = 9 ≤ 29 → check 29 % 3 → not divisible
i = 4 → 4*4 = 16 ≤ 29 → check 29 % 4 → not divisible
i = 5 → 5*5 = 25 ≤ 29 → check 29 % 5 → not divisible
i = 6 → 6*6 = 36 > 29 → stop

No divisors found → 29 is prime
We stopped at i = 6 because any factor beyond √29 would have a corresponding factor below √29.

Example 2: n = 64 (composite / perfect square)
√64 = 8 → check integers i = 2, 3, ..., 8

Using the loop:
i = 2 → 2*2 = 4 ≤ 64 → check 64 % 2 → divisible → stop

We found a divisor immediately → 64 is not prime

Notice, we don’t need to check beyond √64, because any factor greater than 8 (like 16, 32) pairs with a factor ≤ 8.
*/


/*
and why Math.sqrt is not used and this is used i * i <= n

Ah! This is a very common question in interviews — why we use i * i <= n instead of i <= Math.sqrt(n). Let me explain clearly.

Reason 1: Avoid Floating-Point Errors

Math.sqrt(n) returns a double (decimal number), not an integer.
Comparing integers with doubles can sometimes cause rounding errors, especially for large numbers.

Reason 2: Avoid Expensive Function Calls

Math.sqrt(n) is a function call that calculates the square root at runtime.

For large numbers or repeated calls (like checking many primes), it slows down the code.

Multiplication (i * i) is much faster than calling a square root function.

Reason 3: Cleaner and Safer in Loops

Using i * i <= n works directly with integers in the loop:

for (int i = 2; i * i <= n; i++)


No need for casting or converting types.

*/