class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If concatenated strings are not equal, there is no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of the lengths of both strings
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the prefix of str1 up to the GCD length
        return str1.substring(0, gcdLength);
    }

    // Helper method to compute GCD using Euclidean Algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}