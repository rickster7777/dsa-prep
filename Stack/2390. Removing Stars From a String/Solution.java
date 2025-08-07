public class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // Remove last character (simulate stack pop)
                stack.deleteCharAt(stack.length() - 1); // Remove the last character
            } else {
                // Add current character to stack (simulate stack push)
                stack.append(ch); // Add the character to the stack
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeStars("leet**code*")); // Output: "lecoe"
    }
}

/*
Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
 
 */