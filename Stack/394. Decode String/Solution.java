import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();    // Stack to store previous strings
        Stack<Integer> numStack = new Stack<>();   // Stack to store repeat counts
        String currentStr = "";                    // Current decoded string
        int currentNum = 0;                        // Current repeat count

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Accumulate the current number (could be more than one digit)
                // Character.getNumericValue(ch);
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current string and number to stacks
                strStack.push(currentStr);
                numStack.push(currentNum);
                currentStr = "";
                currentNum = 0;
            } else if (ch == ']') {
                // Pop number and previous string, repeat current string
                int repeatCount = numStack.pop();
                String prevStr = strStack.pop();
                StringBuilder sb = new StringBuilder(prevStr);
                for (int i = 0; i < repeatCount; i++) {
                    sb.append(currentStr);
                }
                currentStr = sb.toString();
            } else {
                // Add character to current string
                currentStr += ch;
            }
        }
        return currentStr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "3[a2[c]]";
        String output = sol.decodeString(input);
        System.out.println(output);  // Expected: "accaccacc"
    }
}