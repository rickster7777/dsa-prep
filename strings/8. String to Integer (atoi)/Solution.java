/*
The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Example 1:

Input: s = "42"

Output: 42

Explanation:
The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
^
Step 3: "42" ("42" is read in)
^
*/
class Solution {
    public int myAtoi(String s) {

        // Pointer to traverse the string
        int i = 0;

        // Length of the string
        int n = s.length();

        // -------------------------------
        // STEP 1: Skip leading whitespaces
        // -------------------------------
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // --------------------------------------
        // STEP 2: Determine the sign of number
        // --------------------------------------
        // By default, assume the number is positive
        int sign = 1;

        // Check if current character is '+' or '-'
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            // If '-', make sign negative
            if (s.charAt(i) == '-') {
                sign = -1;
            }

            // Move to the next character
            i++;
        }

        // --------------------------------------
        // STEP 3: Build the integer digit by digit
        // --------------------------------------
        int result = 0;

        // Continue while current character is a digit
        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert character digit to integer digit
            // Example:
            // '7' - '0' = 7
            int digit = s.charAt(i) - '0';

            // --------------------------------------
            // STEP 4: Check for overflow BEFORE adding digit
            // --------------------------------------
            //( same thing is also done in Basic Maths -> reverse integer)
            // Integer.MAX_VALUE = 2147483647
            //
            // If result > 214748364,
            // multiplying by 10 will definitely overflow.
            //
            // Example:
            // result = 214748365
            // result * 10 = overflow
            //
            // Second condition:
            // result == 214748364
            // and next digit > 7
            //
            // Example:
            // 214748364 * 10 + 8
            // = 2147483648 (overflow)
            //
            if (result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                // Return appropriate boundary value
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            // --------------------------------------
            // STEP 5: Form the number
            // --------------------------------------
            //
            // Example:
            // result = 42
            // digit = 3
            //
            // result = 42 * 10 + 3
            // result = 423
            //
            result = result * 10 + digit;

            // Move to next character
            i++;
        }

        // --------------------------------------
        // STEP 6: Apply sign and return answer
        // --------------------------------------
        return result * sign;
    }
}