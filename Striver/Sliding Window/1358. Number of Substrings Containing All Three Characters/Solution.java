/*

    Example 1:
    Input: s = "abcabc"
    Output: 10
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 


    Example 2:
    Input: s = "aaacb"
    Output: 3
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 


    Example 3:
    Input: s = "abc"
    Output: 1


    * ✅ Number of Substrings Containing All Three Characters
    * Problem: Given a string s consisting only of characters 'a', 'b', and 'c',
    * return the number of substrings containing at least one occurrence of all
    * these characters.
    *
    *
Steps to remember:
Key Idea (Sliding Window):
    1. Maintain a window [left, right] using two pointers.
    2. Expand the window by moving the right pointer and count occurrences of 'a', 'b', and 'c'.
    3. When the window contains at least one of each character, count the valid substrings.
    4. Shrink the window from the left to find new valid substrings.
    5. Return the total count of valid substrings found.
    * Time Complexity: O(n) where n = length of string
    * Space Complexity: O(1) for fixed character set of 'a', 'b', 'c'
*/

public class Solution {

    public int numberOfSubstrings(String s) {
        int left = 0, right = 0;
        int n = s.length();
        int[] count = new int[3]; // To count occurrences of 'a', 'b', 'c'
        int result = 0;

        while (right < n) {
            // Expand the window by moving the right pointer
            count[s.charAt(right) - 'a']++;

            // Check if the current window contains at least one of each character
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // All characters are present, count valid substrings
                result += n - right; // All substrings starting from left to end

                // Shrink the window from the left
                count[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }
        return result;
    }
}
