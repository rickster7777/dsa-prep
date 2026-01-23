import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sfreq = new HashMap<>();

        // Step 1: Check if length of 2 strings are same if not return false.

        // Step 2: Add each character from first string to the map to count its
        // frequency.
        for (char c : s.toCharArray()) {

            if (!sfreq.containsKey(c)) {
                sfreq.put(c, 1);
            } else {
                sfreq.put(c, sfreq.get(c) + 1);
            }

        }

        // Step 3: remove each character from the same map.
        for (char c : t.toCharArray()) {

            if (!sfreq.containsKey(c)) {
                return false;
            }

            sfreq.put(c, sfreq.get(c) - 1);

            if (sfreq.get(c) == 0) {
                sfreq.remove(c);
            }
        }

        if (sfreq.isEmpty())
            return true;
        return false;

        /*
        n = s.length()
        m = t.length()

        Step 1: Build frequency map from s O(n)
        Step 2: Reduce frequency using t O(m)

        Total Time Complexity: O(n + m)
        
        💾 Space Complexity
        HashMap storage
        Stores at most one entry per distinct character in s
        Worst case (all characters unique):
        O(k)

        Where:
        k = number of unique characters
        k ≤ n
        ➡️ O(n) in worst case


        Final Answer (Interview-ready)

        Time Complexity:
        O(n + m) → effectively O(n)

        Space Complexity:
        O(n) in the worst case (due to HashMap)
        */
    }

    // Second way to check whether the spring is anagram.

    public boolean isAnagramArray(String s, String t) {

        /*
         * ⏱ Time: O(n)
         * 💾 Space: O(1) (for fixed alphabet like lowercase letters)
         * 
         * Very clear logic
         * Works in streaming / large inputs
         */
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }

    // Third way to check whether the spring is anagram.

    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);

        /*
         * Tradeoff
         * ⏱ Time: O(n log n)
         * 👍 Very intuitive
         * 👎 Not optimal for large data
         * 
         * Use this if:
         * You’re in a hurry
         * Language/library makes sorting trivial
         * Interviewer prioritizes clarity over optimality
         */
    }

    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        String s1 = "anagram", t1 = "nagaram"; // expected: true
        String s2 = "rat", t2 = "car"; // expected: false
        String s3 = "listen", t3 = "silent"; // expected: true
        String s4 = "a", t4 = "a"; // expected: true
        String s5 = "ab", t5 = "ba"; // expected: true

        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\" -> Output: " + solver.isAnagram(s1, t1));
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\" -> Output: " + solver.isAnagram(s2, t2));
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\" -> Output: " + solver.isAnagram(s3, t3));
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\" -> Output: " + solver.isAnagram(s4, t4));
        System.out.println("Input: s = \"" + s5 + "\", t = \"" + t5 + "\" -> Output: " + solver.isAnagram(s5, t5));
    }
}