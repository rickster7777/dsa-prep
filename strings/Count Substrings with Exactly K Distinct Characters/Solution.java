
public class Solution {

    /**
     * Main function: Count substrings with EXACTLY K distinct characters.
     * 
     * APPROACH: Use the "at most" technique.
     * - Substrings with exactly K distinct = (at most K) - (at most K-1)
     * 
     * Example: s = "pqpqs", k = 2
     * - Substrings with at most 2 distinct chars: 8
     * - Substrings with at most 1 distinct char: 1
     * - Result: 8 - 1 = 7 (exactly 2 distinct)
     */
    public static int substrCount(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    /**
     * Helper function: Count substrings with AT MOST K distinct characters.
     * Uses a sliding window approach with two pointers (left and right).
     * 
     * STRATEGY:
     * - Expand window by moving right pointer
     * - When we exceed k distinct chars, shrink from left
     * - Count all valid substrings ending at right: (right - left + 1)
     */
    private static int atMost(String s, int k) {
        if (k == 0) return 0; // Edge case: no substrings with 0 distinct chars

        // freq[i] = frequency of character with ASCII value i
        int[] freq = new int[256];
        int left = 0;           // Left pointer of sliding window
        int count = 0;          // Total count of valid substrings
        int distinct = 0;       // Number of distinct characters in current window

        // Expand the window by moving right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If this character appears for the first time, increment distinct count
            if (freq[c] == 0) {
                distinct++;
            }
            // Increment frequency of current character
            freq[c]++;

            // If we exceed k distinct characters, shrink window from left
            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;                    // Decrease frequency
                if (freq[leftChar] == 0) {
                    distinct--;                      // One less distinct character
                }
                left++;                              // Move left pointer right
            }

            // Add count of all substrings ending at right
            // Window is [left, right], so there are (right - left + 1) substrings
            count += (right - left + 1);
        }

        return count;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        // Sample inputs
        String s1 = "pqpqs";
        int k1 = 2;

        String s2 = "aabacbebebe";
        int k2 = 3;

        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + substrCount(s1, k1));
        System.out.println("Expected: 7\n");

        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + substrCount(s2, k2));
    }
}
