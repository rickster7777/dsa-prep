/*
To check whether an integer is a palindrome, we use the most efficient approach of reversing only half of the number instead of reversing the entire integer or
converting it to a string. We first eliminate cases that can never be palindromes, such as negative numbers and numbers ending with 0 (except 0 itself).

Then, we iteratively move digits from the end of the number to a new variable until the reversed half becomes greater than or equal to the remaining half.

This works because a palindrome reads the same forward and backward, so only half the digits need to be compared. This method is optimal because it avoids
integer overflow, uses constant space, performs fewer operations, and is the preferred interview-standard solution.

*/

class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindromes because of the '-' sign
        // Numbers ending with 0 (but not 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // This will store the reversed second half of the number
        int rev = 0;

        // Reverse digits until we reach (or cross) the middle of the number
        while (x > rev) {

            // Take the last digit of x and add it to rev
            rev = rev * 10 + x % 10;

            // Remove the last digit from x
            x /= 10;
        }

        // For even number of digits: x == rev
        // For odd number of digits: middle digit is ignored using rev / 10
        return x == rev || x == rev / 10;
    }
}

/*

Mathematical concepts to remember from this that can help in other problems as well.

Here are the key mathematical concepts from this palindrome-number problem that are very useful across many other problems, not just this one. Think of these as reusable tools 🧠

1️⃣ Modulo (%) to Extract Digits

Concept:
n % 10 gives the last digit of a number.

Why it matters:

Digit extraction

Sum of digits

Reversing numbers

Checking divisibility

Used in problems like:

Reverse Integer

Sum of Digits

Armstrong / Narcissistic Numbers

Digital Root

2️⃣ Integer Division (/) to Remove Digits

Concept:
n / 10 removes the last digit.

Why it matters:

Traversing a number digit by digit

Reducing a number step by step

Used in problems like:

Count digits

Palindrome numbers

Base conversion

Digit DP problems (basics)

3️⃣ Number Reconstruction (Base-10 Positional Value)

Concept:
newNumber = oldNumber * 10 + digit

Why it matters:

Rebuilding numbers from digits

Understanding place value

Used in problems like:

Reverse integer

String → Integer conversion

Building numbers in greedy algorithms

4️⃣ Symmetry in Numbers (Mirror Property)

Concept:
A palindrome has mirror symmetry around its center.

Why it matters:

Only half comparison is needed

Reduces unnecessary computation

Used in problems like:

Palindrome strings

Valid palindrome with removals

Symmetry checks in arrays

5️⃣ Early Elimination Using Mathematical Properties

Concept:
Some inputs can be rejected immediately using math rules.

Examples:

Negative numbers → never palindromes

Numbers ending in 0 (except 0) → not palindromes

Why it matters:

Saves time

Simplifies logic

Used in problems like:

Prime checks

Perfect squares

Valid number problems

6️⃣ Partial Processing Instead of Full Processing

Concept:
Process only what is necessary (half the digits instead of all).

Why it matters:

Avoids overflow

Improves efficiency

Used in problems like:

Binary search

Two-pointer techniques

Fast exponentiation

7️⃣ Handling Odd vs Even Length Numbers

Concept:
Odd-length numbers have a middle digit that doesn’t affect symmetry.

Why it matters:

Divide by 10 to remove the middle digit

Used in problems like:

Palindrome checks

Linked list palindrome

String center expansion

8️⃣ Loop Invariants

Concept:
At each step:

x holds the first half

rev holds the reversed second half

Why it matters:

Helps reason about correctness

Crucial in interview explanations

Used in problems like:

Two-pointer algorithms

Sliding window

Prefix/suffix computations

9️⃣ Overflow Awareness

Concept:
Avoid growing numbers beyond integer limits.

Why it matters:

Prevents runtime errors

Leads to safer algorithms

Used in problems like:

Reverse Integer

Power calculations

Factorial problems
 */