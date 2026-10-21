/*
Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:

Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.


Constraints:
1 <= s.length, goal.length <= 2 * 10<sup>4</sup>
s and goal consist of lowercase letters.
*/
public class Solution {

    public static boolean BuddyStrings(String s, String goal) {
        // Your Code here

        if (s.length() != goal.length())
            return false;

        int i = 0, n = s.length(), count = 0;

        int first = -1;
        int second = -1;

        // STEP 1: Count the number of characters that are different in both strings
        // STEP 2: Store the indices of the first and second different characters because we need to swap them later
        while (i < n) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
            }

            if (first == -1) {
                first = i;
            } else {
                second = i;
            }

            i++;
        }

        if (count == 1 || count > 2) {
            return false;
        }
        // If the strings are equal, we need to check if there is a duplicate character in the string.
        // If there is a duplicate character, we can swap the two characters and still have the same string.
        // If there is no duplicate character, we cannot swap any characters and still have the same string.
        if (count == 0) {

            // Need a duplicate character so that
            // swapping two equal characters changes nothing
            boolean[] seen = new boolean[26];

            for (int j = 0; j < n; j++) {

                int index = s.charAt(j) - 'a';

                if (seen[index]) {
                    return true;
                }

                seen[index] = true;
            }

            return false;
        }
        return s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first);
    }
}
