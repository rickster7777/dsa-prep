
import java.util.Set;
import java.util.HashSet;

/*
s = "eceba"
k = 2

s = "aa"
k = 1

s = "aabbcc"
k = 2

s = "abcadcacacaca"
k = 3

*/
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();

        int left = 0, right = 0, maxLength = 0;

        Set<Integer> set = new HashSet<>();

        while (right < n) {

            if(!set.add(s.charAt(right)) && set.size() == k){

                maxLength = Math.max(maxLength, right - left + 1);
                left++;
            }


            right++;
        }

        return maxLength;
    }


    public int lengthOfLongestSubstringKDistinctfix(String s, int k) {

        // STEP 1:
        // Handle edge cases.
        // If k = 0, no characters are allowed.
        // If the string is empty, return 0.
        if (k == 0 || s.length() == 0) {
            return 0;
        }

        // STEP 2:
        // Create a HashMap to store:
        // Character -> Frequency inside the current window.
        Map<Character, Integer> map = new HashMap<>();

        // STEP 3:
        // Initialize the left pointer of the sliding window
        // and a variable to store the maximum valid window length.
        int left = 0;
        int maxLength = 0;

        // STEP 4:
        // Expand the window by moving the right pointer.
        for (int right = 0; right < s.length(); right++) {

            // STEP 5:
            // Include the current character into the window
            // by increasing its frequency.
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // STEP 6:
            // If the window has more than k distinct characters,
            // shrink the window from the left.
            while (map.size() > k) {

                // Character leaving the window.
                char leftChar = s.charAt(left);

                // Decrease its frequency.
                map.put(leftChar, map.get(leftChar) - 1);

                // STEP 7:
                // If the frequency becomes 0,
                // completely remove it from the map.
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                // STEP 8:
                // Move the left pointer forward
                // to continue shrinking the window.
                left++;
            }

            // STEP 9:
            // At this point, the window contains
            // at most k distinct characters.
            // Update the maximum window length.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // STEP 10:
        // Return the longest valid substring length.
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 2)); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstringKDistinct("aa", 1)); // Expected: 2
        System.out.println(solution.lengthOfLongestSubstringKDistinct("aabbcc", 2)); // Expected: 4
        System.out.println(solution.lengthOfLongestSubstringKDistinct("abcadcacacaca", 3)); // Expected: 7
    }

}
