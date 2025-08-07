import java.util.HashMap;

public class Solution {

    // public String minWindow(String s, String t) {

    // int i = 0, left = 0, right = 0, tCount = 0, len = s.length(), minLen = 0;
    // HashSet<Character> seen = new HashSet<>();

    // while (right < len) {
    // char currentChar = s.charAt(right);

    // if (currentChar == t.charAt(tCount)) {
    // tCount++;
    // } else {
    // right++;
    // }
    // if (tCount == t.length()) {
    // minLen = Math.min(minLen, right - left + 1);
    // left++;
    // tCount = 0;
    // }
    // }

    // return t;
    // }
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        // Step 1: Count the frequency of each character in string t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use sliding window technique to scan string s
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int have = 0, need = tFreq.size(); // 'have' counts how many required characters we've satisfied
        int minLen = Integer.MAX_VALUE; // Length of the smallest valid window found
        int minStart = 0; // Start index of the smallest valid window

        // Step 3: Expand the window by moving the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If the current character is required and we have exactly the required count,
            // increment 'have'
            if (tFreq.containsKey(c) && window.get(c).intValue() == tFreq.get(c).intValue()) {
                have++;
            }

            // Step 4: Try to shrink the window from the left as long as all required
            // characters are present
            while (have == need) {
                // Update minimum window if this one is smaller
                if ((right - left + 1) < minLen) {
                    minStart = left;
                    minLen = right - left + 1;
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If a required character's count falls below what's needed, reduce 'have'
                if (tFreq.containsKey(leftChar) && window.get(leftChar) < tFreq.get(leftChar)) {
                    have--;
                }

                left++; // Move the left pointer forward to shrink the window
            }

            right++; // Move the right pointer forward to expand the window
        }

        // Step 5: Return the smallest window, or "" if no such window exists
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Test case 1: " + sol.minWindow(s, t)); // Output: 3
    }

}
/*
Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */



/*
 * Your current implementation for Leetcode 76. Minimum Window Substring has
 * several issues:
 *
 * ❌ Issues in your Code:
 * HashSet<Character> seen is declared but never used.
 * You’re comparing characters in s directly with t.charAt(tCount) linearly,
 * which:
 * Ignores character frequency (you must handle duplicates).
 * Assumes order of characters in t should match in s, which is not required.
 * minLen is initialized to 0, so Math.min(minLen, …) will always return 0 — not
 * helpful.
 * The return t; at the end doesn't return the actual substring — it just
 * returns t, which is incorrect.
 * 
 * ✅ Correct Approach (Sliding Window + Frequency Map)
 * We need:
 * A hashmap to store character frequencies in t
 * A window sliding over s to try and match all characters in t
 * To shrink the window whenever all characters of t are found, to find the
 * minimum length
 * 
 * ✅ Fixed & Working Java Code (O(m + n) Time):
 */