// 29. Divide Two Integers
/*
Key idea

Use bit shifting to simulate division efficiently.

Division is repeated subtraction.

Instead of subtracting the divisor one by one (too slow),
double the divisor using left shifts (<<) until it fits into the dividend.

Subtract the largest possible shifted divisor each time.

This gives O(log n) time.

Algorithm:
1. Handle edge cases:
    Division by zero
    Overflow (e.g., -2³¹ / -1)

2. Work with absolute values.

3. Repeatedly:
    Find the largest power of two such that
    (divisor << shift) <= dividend

    Subtract it and add 1 << shift to the result

4. Apply the correct sign.

Complexity
Time: O(log n)
Space: O(1)

Key Concepts Used
Bit shifting (<<) to simulate multiplication by 2
Subtraction to simulate division
XOR (^) to determine sign
long to avoid overflow
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        // ----------------------------------------------------
        // 1. Handle special / edge cases
        // ----------------------------------------------------

        // Division by zero is undefined
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        // Overflow case:
        // Integer.MIN_VALUE = -2^31
        // Integer.MAX_VALUE =  2^31 - 1
        // (-2^31) / (-1) = 2^31 → overflow, so return MAX_VALUE
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // ----------------------------------------------------
        // 2. Determine the sign of the result
        // ----------------------------------------------------
        // XOR (^) returns true if exactly one operand is true
        // Result is negative if dividend and divisor have different signs
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // ----------------------------------------------------
        // 3. Convert both numbers to positive values
        // ----------------------------------------------------
        // Use long to safely handle Integer.MIN_VALUE
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // This will store the final quotient
        int quotient = 0;

        // ----------------------------------------------------
        // 4. Repeatedly subtract the largest shifted divisor
        // ----------------------------------------------------
        // While the remaining dividend is still large enough
        while (absDividend >= absDivisor) {

            // tempDivisor stores the current shifted divisor
            long tempDivisor = absDivisor;

            // multiple keeps track of how many times
            // the divisor has been doubled
            int multiple = 1;

            // ------------------------------------------------
            // Keep doubling the divisor until it exceeds
            // the remaining dividend
            // ------------------------------------------------
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;   // tempDivisor *= 2
                multiple <<= 1;      // multiple *= 2
            }

            // ------------------------------------------------
            // Subtract the largest possible chunk
            // ------------------------------------------------
            absDividend -= tempDivisor;

            // Add the corresponding multiple to quotient
            quotient += multiple;
        }

        // ----------------------------------------------------
        // 5. Apply sign and return result
        // ----------------------------------------------------
        return negative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();

        int dividend = 10;
        int divisor = 3;

        int result = solution.divide(dividend, divisor);
        System.out.println("Quotient: " + result); // Expected output: 9

        int resultSub = solution.divideSubtraction(dividend, divisor);
        System.out.println("Quotient (Subtraction): " + resultSub); // Expected
    }

    //simpler (but slower) subtraction-only solution .
    public int divideSubtraction(int dividend, int divisor) {
        // Handle edge cases
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Repeatedly subtract the divisor from the dividend
        while (absDividend >= absDivisor) {
            absDividend -= absDivisor;
            quotient++;
        }

        return negative ? -quotient : quotient;
    }
}
