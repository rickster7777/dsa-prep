/*
 * Thought process inhere
 * Set cannot be used directly as it does not maintain order.
 */

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1); // pop
            } else {
                stack.append(c); // push
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("abbaca")); // Output: "ca"
        System.out.println(sol.removeDuplicates("azxxzy")); // Output: "ay"
    }
}
/*
Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".


Example 2:
Input: s = "azxxzy"
Output: "ay"
 */