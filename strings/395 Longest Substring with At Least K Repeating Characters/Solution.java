public class Solution {
    // Returns length of longest substring where every character in that substring appears at least k times
    public static int longestSubstring(String s, int k) {
        int maxLength = 0;            // best answer found so far
        int n = s.length();           // length of the input string

        // Step: try every possible substring start index i
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency counts for letters 'a'..'z' for current window starting at i

            // Step: extend the substring one character at a time from i to end
            for (int j = i; j < n; j++) {
                // include s[j] into the current window by incrementing its frequency
                freq[s.charAt(j) - 'a']++;

                // check if the current window [i..j] is valid: every present char appears >= k times
                if (isValid(freq, k)) {
                    // update maximum with the length of this valid window
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        // after checking all windows, return the maximum length found
        return maxLength;
    }

    // Helper: returns true if every character that appears in freq[] appears at least k times
    private static boolean isValid(int[] freq, int k) {
        // iterate over all letter counts
        for (int count : freq) {
            // if a letter is present (count > 0) but occurs less than k times, window is invalid
            if (count > 0 && count < k) {
                return false;
            }
        }
        // all present letters satisfy the >= k requirement
        return true;
    }

    public static void main(String[] args) {
        String s = "aaabb";           // example input string
        int k = 3;                    // required minimum frequency per character in substring
        // call brute-force implementation and print the result (expected 3 for "aaa")
        System.out.println("Brute force: " + longestSubstring(s, k));
    }
}
// ...existing code...
/*
         * Substring "aaa" → valid (each a appears 3 times)Substring "aab" → invalid (b appears less than 3 times)
         * Output = 3
         */
