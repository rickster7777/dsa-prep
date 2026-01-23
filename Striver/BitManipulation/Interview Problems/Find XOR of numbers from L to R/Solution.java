class Solution {

    /*
     * Function to find the XOR of numbers from L to R
     */
    public int findRangeXOR(int l, int r) {

        // To store the XOR of numbers
        int ans = 0;

        // XOR all the numbers
        for (int i = l; i <= r; i++) {
            ans ^= i;
        }

        // Return the result
        return ans;
    }
    // Above has time complexity O(N)

    // More optimized approach
    /*
     * Algorithm:
     * The XOR of numbers from 1 to n follows a predictable pattern based on n % 4.
     * This pattern helps compute XOR from 1 to any number n in constant time.
     * To get XOR of numbers in the range [L, R], compute XOR(1 to R) and XOR(1 to L- 1).
     * Apply XOR between these two results, common prefixes cancel out due to XOR properties.
     * This approach avoids looping through the range and achieves optimal performance.
     */
    private int XORtillN(int n) {
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        if (n % 4 == 3)
            return 0;
        return n;
    }

    /*
     * Function to find the XOR
     * of numbers from L to R
     */
    public int findRangeXOROp(int l, int r) {
        return XORtillN(l - 1) ^ XORtillN(r);
    }

    public static void main(String[] args) {
        int l = 3, r = 5;

        /*
         * Creating an instance of Solution class
         */
        Solution sol = new Solution();

        /*
         * Function call to get the XOR of numbers from L to R
         */
        int ans = sol.findRangeXOR(l, r);

        System.out.println("The XOR of numbers from " + l + " to " + r + " is: " + ans);
    }
}
