import java.math.BigInteger; // Fixed import (should be java.math.BigInteger, not java.Math.BigInteger)

public class Factorial {
    // Calculates factorial using int (works for small n)
    public static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    /*
     * Our current implementation uses int, which cannot handle large factorials
     * because:
     * 
     * int overflows after about 12! (since 13! = 6227020800, which exceeds int max
     * value: 2,147,483,647).
     * long works up to around 20! before it overflows.
     * For larger inputs (like 50!, 100!, etc.), you should use BigInteger.
     * 
     * 
     * In Java, you can't use *= with BigInteger, because BigInteger is an immutable
     * class, meaning its value does not change once created.
     * 
     * ❌ This won’t work:
     * fact *= BigInteger.valueOf(i); // Invalid — compile-time error
     * 
     * 
     * ✅ This is correct:
     * fact = fact.multiply(BigInteger.valueOf(i));
     * Why?
     * 
     * fact.multiply(...) returns a new BigInteger object with the result.
     * 
     * You need to assign it back to fact explicitly.
     * 
     * So this multiply method goes only with biginteger
     * 
     * ChatGPT said:
     * Exactly! The multiply method is specific to BigInteger (and similar classes
     * like BigDecimal) in Java.
     * 
     * 
     */

    // Calculates factorial for large numbers using BigInteger
    public static BigInteger factorialForLargeNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        BigInteger fact = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }

    public static int factRecursion(int n) {

        int fact = 1;

        if (n <= 1) {
            return fact;
        }

        return n * factRecursion(n - 1);
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println("Factorial (int): " + Factorial.factorial(n));
        System.out.println("Factorial (BigInteger): " + Factorial.factorialForLargeNumbers(n));
        System.out.println("Factorial recursion: " + Factorial.factRecursion(n));
    }
}