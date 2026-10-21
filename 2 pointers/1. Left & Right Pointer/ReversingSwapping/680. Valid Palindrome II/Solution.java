
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
The goal is to determine whether a string can become a palindrome after deleting zero or one character.

Example 1:

Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

*/
class Solution {

    // public boolean validP(StringBuilder sb) {
    //     int start = 0;
    //     int end = sb.length() - 1;
    //     while (start < end) {
    //         if (sb.charAt(start) == sb.charAt(end)) {
    //             start++;
    //             end--;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean validPalindrome(String s) {
    //     if (s.length() == 1) return true;
    //     for (int i = 0; i < s.length(); i++) {
    //         StringBuilder sb = new StringBuilder(s);
    //         sb.deleteCharAt(i);
    //         boolean result = validP(sb);
    //         if (result) {
    //             return true;
    //         } else {
    //             continue;
    //         }
    //     }
    //     return false;
    // }
    // Above sol gave TLE
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
            /*
             Is the same as writing:
             char leftChar = s.charAt(left);
             char rightChar = s.charAt(right);
             left++;  // move left pointer forward
             right--; // move right pointer backward
     
             if (leftChar != rightChar) {
                 return false;
             }
             */
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aba"; // output: true
        //explanation:

        boolean result = sol.validPalindrome(s);
        System.out.println(result);

    }
}


/*
 🔍 Evaluation
✅ What’s good:
✔️ Correct logic for checking a palindrome with at most one deletion.
✔️ Uses a helper method for clarity (validP).
✔️ Clean structure.

⚠️ Areas for Improvement:
Time Complexity:
Your current approach runs in O(n²) time:

For each character (O(n)), you're creating a new string and checking if it's a palindrome (O(n)).

This is not optimal.

StringBuilder usage:
Using StringBuilder and deleteCharAt(i) creates a new string each time, which is unnecessary and inefficient.

Cleaner logic possible:
You can solve this in O(n) time using a two-pointer approach that tries skipping at most one mismatched character.
 */