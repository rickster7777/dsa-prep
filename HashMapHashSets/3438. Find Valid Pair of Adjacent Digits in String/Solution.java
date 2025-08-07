/*
Example 1:
Input: s = "2523533"
Output: "23"
Explanation:
Digit '2' appears 2 times and digit '3' appears 3 times. Each digit in the pair "23" appears in s exactly as many times as its numeric value. Hence, the output is "23".

Example 2:
Input: s = "221"
Output: "21"
Explanation:
Digit '2' appears 2 times and digit '1' appears 1 time. Hence, the output is "21".

Example 3:
Input: s = "22"
Output: ""
Explanation:

There are no valid adjacent pairs.
 */
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String findValidPair(String s) {
        char[] nums = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        StringBuilder sb  = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey().toString().equals(entry.getValue().toString())) {
                sb.append(entry.getKey());
            }
        }
        /*
        So this is the right logic:

        if (map.get(digit) == Character.getNumericValue(digit))
        Or more fully in your context:


        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (first != second &&
                map.get(first) == Character.getNumericValue(first) &&
                map.get(second) == Character.getNumericValue(second)) {
                return "" + first + second;
            }
        }
                 */
        //Sort and check if tthey're adjacent
        return "";
    }

    public static String findValidPairFixed(String s) {
        // Step 1: Count digit frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Loop through adjacent digit pairs
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);

            if (a == b) continue; // must be different

            int countA = freq.get(a);
            int countB = freq.get(b);

            // Check if both digits appear exactly as many times as their numeric value
            if (countA == (a - '0') && countB == (b - '0')) {
                return "" + a + b;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] testCases = { "2523533", "221", "22" };
        for (String s : testCases) {
            String result = findValidPairFixed(s);
            System.out.println("Input: " + s + " | Output: " + result);
        }
    }
}