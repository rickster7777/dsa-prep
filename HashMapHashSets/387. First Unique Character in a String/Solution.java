/*
Input: "swiss"
Output: 'w'
Explanation: 's' repeats, 'w' does not, and appears first.
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    // first approach
    public char getFirstUnique(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // or return '\0' or -1 depending on requirement

    }

    // second approach 2️⃣ Better (when character set is limited) — Frequency Array

    public static char getFirstUniqueFreq(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }

        return '\0';

    }

    // 3️⃣ Two-pass HashMap (without LinkedHashMap)

    public char getFirstUniqueTwoPass(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return '0';
    }

    public static void main(String[] args) {
        System.out.println(getFirstUniqueFreq("leetcode")); // l
        System.out.println(getFirstUniqueFreq("loveleetcode")); // v
    }

    // In the LC prob 387 It's required that instead of character index needs to be
    // returned
    // So this code highlights how index can be tracked along with the character.

    public int firstUniqChar(String s) {
        Map<Character, int[]> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, new int[] { 1, i }); // count, first index
            } else {
                map.get(c)[0]++;
            }
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] == 1) {
                return entry.getValue()[1]; // return index
            }
        }
        return -1;
    }
}
