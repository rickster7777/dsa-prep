import java.util.Stack;
/*
 Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 */

class Solution {
    public String removeDuplicates(String s, int k) {
        // StringBuilder used as a stack to build the final result
        StringBuilder sb = new StringBuilder();

        // Stack to keep track of the count of consecutive characters
        Stack<Integer> countStack = new Stack<>();

        // Iterate over each character in the input string
        for (char c : s.toCharArray()) {
            int len = sb.length();

            // Check if current character is same as the last character in sb (top of the
            // "stack")
            if (len > 0 && sb.charAt(len - 1) == c) {
                // Get the last count from the count stack and increment it
                int count = countStack.pop() + 1;

                // If count reaches k, remove the last k-1 characters (already added c once)
                if (count == k) {
                    //deleting in range
                    sb.delete(sb.length() - k + 1, sb.length());
                } else {
                    // Otherwise, append the character and push the updated count
                    sb.append(c);
                    countStack.push(count);
                }
            } else {
                // New character different from the last one
                sb.append(c); // Push character onto the stack
                countStack.push(1); // Start count for this new character
            }
        }

        // Return the built result as a string
        return sb.toString();
    }
}
