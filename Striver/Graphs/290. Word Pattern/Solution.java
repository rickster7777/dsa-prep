import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        int pLen = pattern.length();

        String[] str = s.split(" ");

        int sLen = str.length;

        if (pLen != sLen)
            return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pLen; i++) {

            if (map.containsKey(pattern.charAt(i))) {

                if (!map.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), str[i]);
            }
        }

        return true;
    }

    /*
     * Your code correctly checks one direction of the mapping:
     * 
     * Character → Word
     * 
     * But LeetCode 290. Word Pattern requires a bijection (one-to-one mapping):
     * 
     * Each character maps to exactly one word. ✅ (your code does this)
     * Each word maps to exactly one character. ❌ (your code is missing this)
     * Failing Example
     * pattern = "abba"
     * s = "dog dog dog dog"
     */

    public boolean wordpattewrnFix(String pattern, String s) {
        // Fix 1 (Recommended): Use Two HashMaps

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] str = s.split(" ");

        // Number of pattern characters and words must match
        if (pattern.length() != str.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = str[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word))
                    return false;
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c)
                    return false;
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    /*
    Here's the complete solution using your second approach (single HashMap + containsValue()).

    Note: This solution is correct but has O(n²) time complexity because containsValue() scans all values in the map. It is accepted
    on LeetCode, but using two HashMaps is more efficient (O(n)).
    */

    public boolean wordPatternShorter(String pattern, String s) {

        // Split the string into individual words
        String[] words = s.split(" ");

        // If lengths don't match, pattern cannot be formed
        if (pattern.length() != words.length) {
            return false;
        }

        // Map to store Character -> Word mapping
        Map<Character, String> map = new HashMap<>();

        // Traverse both pattern and words together
        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // If character is already mapped
            if (map.containsKey(ch)) {

                // Check if it maps to the same word
                if (!map.get(ch).equals(word)) {
                    return false;
                }

            } else {

                // Character is not mapped yet.
                // But if another character is already mapped to this word,
                // then mapping is not one-to-one.
                if (map.containsValue(word)) {
                    return false;
                }

                // Create new mapping
                map.put(ch, word);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Example 1
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";

        System.out.println("Example 1:");
        System.out.println(new Solution().wordPattern(pattern1, s1));
        // Expected Output: true

        // Example 2
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";

        System.out.println("Example 2:");
        System.out.println(new Solution().wordPattern(pattern2, s2));
        // Expected Output: false

        // Example 3
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";

        System.out.println("Example 3:");
        System.out.println(new Solution().wordPattern(pattern3, s3));
        // Expected Output: false
    }
}
