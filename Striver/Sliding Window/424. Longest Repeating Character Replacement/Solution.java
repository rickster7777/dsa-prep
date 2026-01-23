/**
 *Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.


    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4

    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".

    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.


 * ✅ Longest Repeating Character Replacement
 * Problem: Find the length of the longest substring containing the same letter
 * after performing at most k replacements of any character.
 *
 * Key Idea (Sliding Window):
 * - Maintain a window [left, right] using two pointers
 * - For each window, track the frequency of all characters
 * - Let maxCount = frequency of the most common character in the window
 * - Characters to replace in window = window_length - maxCount
 * - If characters_to_replace > k, shrink the window from left
 * - We do NOT decrease maxCount when shrinking — this keeps it O(n) and correct
 * (we only care about the answer, not intermediate invalid windows)
 *
 * Time Complexity: O(n) where n = length of string
 * Space Complexity: O(1) for fixed alphabet size of 26
 */
public class Solution {
    /**
     * Finds the longest substring with at most k character replacements
     *
     * @param s the input string (uppercase letters only)
     * @param k maximum number of character replacements allowed
     * @return length of the longest valid substring
     */
    public int characterReplacement(String s, int k) {
        // STEP 0: Initialize data structures
        // Array to store frequency of each character (A-Z has indices 0-25)
        int[] count = new int[26];

        // Tracks the maximum frequency of any character in the current window
        // Key optimization: We never decrease this value to maintain O(n) complexity
        int maxCount = 0;

        // Left pointer of the sliding window
        int left = 0;

        // Stores the maximum valid window size found so far
        int maxLength = 0;

        // STEP 1: Expand the window by moving right pointer
        for (int right = 0; right < s.length(); right++) {

            // STEP 2: Add the character at right pointer to the window
            count[s.charAt(right) - 'A']++;

            // STEP 3: Update maxCount to track the most frequent character
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // STEP 4: Check if window is valid
            // Characters to replace = window_length - maxCount
            // If replacements needed > k, window is invalid

            // STEP 5: Shrink the window from left until it becomes valid
            while (right - left + 1 - maxCount > k) {
                // Remove the leftmost character from frequency map
                count[s.charAt(left) - 'A']--;

                // Move left pointer forward to shrink the window
                left++;
            }

            // STEP 6: Update the maximum length with current valid window size
            // At this point, the window [left, right] is guaranteed to be valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // STEP 7: Return the maximum length found
        return maxLength;
    }

    /**
     * Test cases demonstrating the algorithm
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: "AABABBA" with k=1
        // Explanation: Replace 1 'B' -> "AAAA" has length 4 (indices 0-3)
        // or "AAAAABA" after replacing middle B -> longest "AAAA"
        String s = "AABABBA";
        int k = 1;
        System.out.println(sol.characterReplacement(s, k)); // Output: 4

        // Test Case 2: "ABAB" with k=2
        // Explanation: Replace both 'A's with 'B' (or vice versa) -> "BBBB" length 4
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(sol.characterReplacement(s1, k1)); // Output: 4
    }
}

/*
Is it somewhat similar to the consecutive Ones III problem ?

Similarities:
+--------------------------+-----------------------------------------------+----------------------------------------------+
| Category                 | 424. Longest Repeating Character Replacement | 1004. Max Consecutive Ones III                |
+--------------------------+-----------------------------------------------+----------------------------------------------+
| Input Type               | String (A–Z characters)                       | Binary array (0s and 1s)                      |
| Allowed Operation        | Replace any character                         | Flip 0 to 1                                  |
| What k Represents        | Max number of replacements                   | Max number of zero flips                     |
| Window Valid When        | Characters to replace ≤ k                    | Zeros in window ≤ k                          |
| How Window Cost is Measured| Window size − highest frequency              | Count of zeros                               |
| Primary Variable Tracked | Max frequency of a character                 | Zero counter                                 |
| Reason to Shrink Window  | Too many replacements needed                 | Too many zeros                               |
| Window Goal              | All characters become the same               | All values become 1                          |
| Core Technique           | Sliding window + frequency array             | Sliding window + counter                     |
| Time Complexity          | O(n)                                         | O(n)                                         |
+--------------------------+-----------------------------------------------+----------------------------------------------+


Key Difference:
424: Tracks character frequencies → replaces least frequent chars with most frequent one
1004: Counts zeros in the window → replaces zeros with ones
Both use the same sliding window template but solve different problems. The core logic is identical:

Expand right pointer
Update condition (maxCount vs zeroCount)
Shrink left when invalid
Track maximum window size
*/