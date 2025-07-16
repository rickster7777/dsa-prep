import java.util.HashSet;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLen = 0;
//         int len = 0;

//         StringBuilder word = new StringBuilder();
//         HashSet<Character> seen = new HashSet<>();

//         int count = 0;

//         for (int i = 0; i < s.length(); i++) {
//             if (!seen.contains(s.charAt(i))) {
//                 seen.add(s.charAt(i));
//                 count++;
//             } else {
//                 count = 1;
//             }
//             maxLen = Math.max(maxLen, count);
//         }
//         return maxLen;
//     }
// }


/*
 * That’s incorrect because it doesn't remove characters from the set when
 * duplicates are found and doesn't properly move the
 * left pointer of the sliding window.
 *
 * ✅ Rating of Your Solution: 3/10
 * Pros:
 * You correctly used a HashSet to detect duplicates.
 * You maintained a running maxLen.
 *
 * Cons:
 * Didn't manage the sliding window correctly.
 * Didn't remove previously seen characters when a duplicate was found.
 * Will give wrong answers for cases like "abba" or "dvdf".
 */

 
class Solution {
    /**
     * Returns the length of the longest substring without repeating characters in the given string.
     * Uses the sliding window technique with a HashSet to track unique characters.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        // HashSet to store unique characters in the current window
        HashSet<Character> seen = new HashSet<>();

        // Expand the window with 'right' pointer
        while (right < s.length()) {
            char current = s.charAt(right);
            // If current character is not in the set, add it and update maxLen
            if (!seen.contains(current)) {
                seen.add(current);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                // If duplicate found, remove the leftmost character and move left pointer
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "abba";

        System.out.println("Test case 1: " + sol.lengthOfLongestSubstring(s1)); // Output: 3
        System.out.println("Test case 2: " + sol.lengthOfLongestSubstring(s2)); // Output: 1
        System.out.println("Test case 3: " + sol.lengthOfLongestSubstring(s3)); // Output: 3
        System.out.println("Test case 4: " + sol.lengthOfLongestSubstring(s4)); // Output: 2
    }
}