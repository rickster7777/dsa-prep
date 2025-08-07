/*
Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 
 class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();
        int i = 0, j = 0;

        while (i < s1 && j < s2) {
            if(str1.charAt(i) === str2.charAt(j)){
                i++;
                j++;
                from here how to return only AB instead of complete ABAB
            }else{
                return ""
            }
        }
    }
}
 */

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