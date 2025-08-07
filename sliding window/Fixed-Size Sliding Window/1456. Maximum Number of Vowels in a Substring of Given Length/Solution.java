public class Solution {
    /*
     * 3 ways to check vowels:
     *
     * ✅ 1. Using Set<Character> (Recommended in most cases)
     *
     * private static final Set<Character> VOWELS = Set.of(
     * 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
     * );
     *
     * public static boolean isVowel(char ch) {
     * return VOWELS.contains(ch);
     * }
     *
     *
     * ⚙️ 2. Using "aeiouAEIOU".indexOf(ch) != -1

     * public static boolean isVowel(char ch) {
     * return "aeiouAEIOU".indexOf(ch) != -1;
     * }
     *
     *
     * 🌀 3. Using Streams

     * public static boolean isVowel(char ch) {
     * return Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').anyMatch(v -> v == ch);
     * }
     * ✅ Pros:
     * Functional programming style
     * Easy to read if you're familiar with streams
     *
     * ❌ Cons:
     * Slowest of the three (creates stream on every call)
     * Overhead is not worth it for a simple check
     *
     *
     * 🏆 Best Overall Choice
     * Use the Set<Character> version if:
     * Performance matters (frequent lookups)
     * You may extend the character set later
     * You're working in production code
     * 
     * Use "aeiouAEIOU".indexOf(ch) if:
     * You need a quick, readable check
     * Performance isn’t critical
     * It's a throwaway or interview task
     * 
     * Use Streams if:
     * You're working in a pipeline already
     * You prefer functional style, and performance isn't a concern
     */

    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public int countVowels(String str, int k) {
        if (str == null || str.length() < k || k <= 0) {
            return 0;
        }
        int vowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(str.charAt(i))) {
                vowelCount++;
            }

        }
        int maxVowels = vowelCount;

        for (int i = k; i < str.length(); i++) {
            if (isVowel(str.charAt(i - k))) {
                vowelCount--;
            }

            if (isVowel(str.charAt(i))) {
                vowelCount++;
            }

            maxVowels = Math.max(maxVowels, vowelCount);

            // Early exit if the maxVowel count equals k (optimal condition found)
            if (maxVowels == k) {
                return k;
            }
        }

        return maxVowels;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "abciiidef";
        int k = 3;
        System.out.println(sol.countVowels(str, k));
    }
}