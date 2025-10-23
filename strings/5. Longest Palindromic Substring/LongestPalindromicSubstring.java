/*
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.


Can't figure out how to move pointers in this.

Approach to Solve the Problem:

1. Brute Force Approach:

Check all possible substrings of the given string.
For each substring, check if it's a palindrome.
Time complexity: O(n^3) (for generating substrings and checking if each one is a palindrome).


2. Optimized Approach using Expand Around Center (Most Efficient):
A palindrome mirrors around its center. Therefore, you can treat every character and pair of consecutive characters as the center of a potential palindrome and expand outward.
Time complexity: O(n^2), space complexity: O(1).

Steps:
Loop through each character and expand around it (both for odd-length and even-length palindromes).
Keep track of the longest palindrome found.


3. Dynamic Programming Approach:
Use dynamic programming (DP) to build a table where each cell dp[i][j] is true if the substring s[i:j+1] is a palindrome.
Time complexity: O(n^2), space complexity: O(n^2).
 */

public class LongestPalindromicSubstring {

    // Helper method to expand around the center
    private static String expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as the characters are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the palindrome found by expanding around the center
        return s.substring(left + 1, right);
    }

    // Main method to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String longest = "";

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // Check for even-length palindromes
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    // Test the implementation
    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input)); // Output: "bab" or "aba"
    }
}
