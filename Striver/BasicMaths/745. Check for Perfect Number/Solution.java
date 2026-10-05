class Solution {
    /*
     * Example 1:
     * Input: n = 6
     * Output: true
     * Explanation: Proper divisors of 6 are 1, 2, 3.
     * 
     * 1 + 2 + 3 = 6.

     * Example 2:
     * Input: n = 4
     * Output: false
     * Explanation: Proper divisors of 4 are 1, 2.
     * 1 + 2 = 3.
     */
    public boolean isPerfect(int n) {
        // A perfect number must be positive
        if (n <= 1) {
            return false;
        }

        int sum = 0;

        // Check all possible proper divisors
        for (int i = 1; i <= n / 2; i++) {

            // If i divides n, it is a proper divisor
            if (n % i == 0) {
                sum += i;
            }
        }

        // If sum of proper divisors equals n,
        // then n is a perfect number
        return sum == n;
    }
}