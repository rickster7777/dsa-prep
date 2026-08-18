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
    public int reverse(int num) {

        int rev = 0; // Stores the reversed number

        while (num != 0) {

            int digit = num % 10; // Extract last digit (keeps sign)
            num /= 10; // Remove last digit

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
/*
1. int digit = x % 10;      // Extract last digit
2. x /= 10;                 // Remove last digit
3. rev = rev * 10 + digit;  // Append digit to reversed number

4. int lastDigit = Math.abs(x % 10); // Last digit without sign

5. int firstDigit = x;
   while (firstDigit >= 10) {
       firstDigit /= 10;
   } // Extract first digit

6. int square = x * x;      // Square of a number

7. int cube = x * x * x;    // Cube of a number

8. int absValue = Math.abs(x); // Absolute value

9. int power = (int) Math.pow(x, y); // x raised to y

10. int sqrt = (int) Math.sqrt(x); // Square root

11. int remainder = x % y; // Remainder after division

12. int quotient = x / y;  // Integer division

13. boolean even = (x % 2 == 0); // Check even

14. boolean odd = (x % 2 != 0);  // Check odd

15. boolean divisible = (x % y == 0); // Divisible by y

16. int min = Math.min(a, b); // Minimum

17. int max = Math.max(a, b); // Maximum

18. int gcd = gcd(a, b); // Greatest Common Divisor (Euclid)

19. int lcm = (a * b) / gcd(a, b); // Least Common Multiple

20. int digits = String.valueOf(Math.abs(x)).length(); // Count digits

21. int sumDigits = 0;
    int temp = Math.abs(x);
    while (temp > 0) {
        sumDigits += temp % 10;
        temp /= 10;
    } // Sum of digits

22. int productDigits = 1;
    temp = Math.abs(x);
    while (temp > 0) {
        productDigits *= temp % 10;
        temp /= 10;
    } // Product of digits

23. boolean palindrome = (x == reverse(x)); // Check palindrome

24. boolean armstrong = (x == sumOfPoweredDigits(x)); // Armstrong number

25. boolean prime = isPrime(x); // Prime check

26. int factorial = 1;
    for (int i = 2; i <= x; i++) {
        factorial *= i;
    }

27. int swap;
    swap = a;
    a = b;
    b = swap; // Swap two numbers

28. int random = (int)(Math.random() * 100); // Random number 0–99

29. int sign = Integer.signum(x); // -1, 0, or 1

30. int floor = (int)Math.floor(value);
    int ceil = (int)Math.ceil(value);
    int round = Math.round(value); // Floor, ceil, round
*/