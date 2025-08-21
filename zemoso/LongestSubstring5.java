import java.util.HashSet;

public class LongestSubstring5 {

    public static int lengthOfLongestSubstring(String s) {
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
        String testString = "abcabcbb";
        int result = lengthOfLongestSubstring(testString);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}