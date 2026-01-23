/*
Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

Constraints:
-231 <= x <= 231 - 1

*/

/*

I think I'm not able to add negative sign correctly how to achieve that


class Solution {
    public int reverse(int x) {

        int org = x;
        int rev = 0;

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        if (org > 0) {
            return rev;
        } else {
            return -rev;
        }

    }

    The problem about here is not the handling of negative signs. Java takes care of it automatically 
    The problem is the managing of integer overflow
}

 */

class Solution {
    public int reverse(int x) {

        int rev = 0; // Stores the reversed number

        while (x != 0) {

            int digit = x % 10; // Extract last digit (keeps sign)
            x /= 10; // Remove last digit

            /*
             * BEFORE updating rev, we must check for overflow.
             *
             * Case 1: rev > Integer.MAX_VALUE / 10
             * → multiplying by 10 will overflow immediately
             *
             * Case 2: rev == Integer.MAX_VALUE / 10
             * → multiplying by 10 is safe, but adding digit may overflow
             * → max allowed digit is 7 (for 2147483647)
             */
            if (rev > Integer.MAX_VALUE / 10 ||
                    (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            /*
             * Similar logic for negative numbers.
             *
             * Case 1: rev < Integer.MIN_VALUE / 10
             * Case 2: rev == Integer.MIN_VALUE / 10 and digit < -8
             */
            if (rev < Integer.MIN_VALUE / 10 ||
                    (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Safe to update reversed number
            rev = rev * 10 + digit;
        }

        return rev;
    }
}
