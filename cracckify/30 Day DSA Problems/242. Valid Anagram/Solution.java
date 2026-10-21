
import java.util.*;

public class Solution {

    public static boolean isAnagramArr(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
    /*
    ⏱ Time Complexity
        Convert to char arrays → O(n)

        Sort sArr → O(n log n)
        Sort tArr → O(n log n)
        Compare arrays → O(n)
        ✅ Total Time: O(n log n)

        💾 Space Complexity
        Two char arrays → O(n)
        Sorting may use extra stack space (depends on JVM)
        ✅ Total Space: O(n)
    */
    public static boolean isAnagramFreqCount(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26]; // Assuming only lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0)
                return false;
        }

        return true;
    }
    /*
    ⏱ Time Complexity
    Single pass through strings → O(n)
    Check count array → O(26) ≈ O(1)
    ✅ Total Time: O(n)

    💾 Space Complexity
    Fixed array of size 26
    ✅ Total Space: O(1)
    */
    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                return false;

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0)
                map.remove(c);
        }

        return map.isEmpty();
    }
    /*
    ⏱ Time Complexity
    Build map → O(n)
    Reduce using second string → O(n)
    ✅ Total Time: O(n)


    💾 Space Complexity
    HashMap storing distinct characters → O(k)
    Worst case: O(n)
    ✅ Total Space: O(n)
    */


    /*
     * | Method | Time | Space | Best Use Case |
     * | --------------- | ---------- | -------- | ------------------ |
     * | Sorting (`Arr`) | O(n log n) | O(n) | Simple, Unicode |
     * | Frequency Array | **O(n)** | **O(1)** | Lowercase letters |
     * | HashMap | O(n) | O(n) | General characters |
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "rat", t = "car";

        System.out.println(sol.isAnagramFreqCount(s, t));
    }
}

/*
 * ✅ What’s Good:
 * You’re correctly counting the frequency of each character in s and then
 * decrementing it while processing t.
 * 
 * ❌ What Can Be Improved:
 * Redundant check:
 * The condition:
 * 
 * java
 * Copy
 * Edit
 * if (map.containsKey(i) && map.get(i) > 0) {
 * map.put(i, map.get(i) + 1);
 * } else {
 * map.put(i, map.getOrDefault(i, 0) + 1);
 * }
 * is redundant. You can just use:
 * 
 * java
 * Copy
 * Edit
 * map.put(i, map.getOrDefault(i, 0) + 1);
 * Splitting strings:
 * You’re doing s.split(""), which is inefficient. Better to iterate over char[]
 * using toCharArray().
 * 
 * Use of String as key:
 * Map<String, Integer> could be Map<Character, Integer> which is cleaner and
 * faster for character-based problems.
 * 
 * 
 */
