/*
Example 1:
Input: n1 = 4, n2 = 6

Output: 2

Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6

Greatest Common divisor = 2.

Example 2:
Input: n1 = 9, n2 = 8

Output: 1

Explanation: Divisors of n1 = 1, 3, 9 Divisors of n2 = 1, 2, 4, 8.

Greatest Common divisor = 1.
*/
/*
Idea

If we have:

n1 = 20
n2 = 12

We repeatedly replace:

larger number → remainder

So:
20 % 12 = 8
12 % 8 = 4
8 % 4 = 0

When the remainder becomes 0, the other number is the GCD.

So GCD = 4.

Why does this work?

The key property is:

GCD(a, b) = GCD(b, a % b)

For example:

GCD(20, 12)
      ↓
GCD(12, 8)
      ↓
GCD(8, 4)
      ↓
GCD(4, 0)
      ↓
4

Time: O(log(min(n1, n2)))
Space: O(1)

*/
class Solution {

    public int GCD(int n1, int n2) {
        while (n2 != 0) {

            int remainder = n1 % n2;

            n1 = n2;
            n2 = remainder;
        }

        return n1;
    }
}