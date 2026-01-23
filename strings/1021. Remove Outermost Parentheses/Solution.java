import java.util.Stack;

/*
✅ Explanation

We track how deep we are inside nested parentheses:

When we see '(':
If depth > 0, we append it (it's not the outer parenthesis).
Then increase depth.


When we see ')':
First decrease depth.
If depth > 0, we append it.

Outer parentheses are those where:
'(' transitions depth 0 → 1
')' transitions depth 1 → 0

We skip these.

*/
class Solution {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    result.append(c);  // Not outermost
                }
                depth++;
            } else { // c == ')'
                depth--;
                if (depth > 0) {
                    result.append(c);  // Not outermost
                }
            }
        }

        return result.toString();
    }

    public String removeOuterParenthesesStack(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If stack is not empty, this '(' is not outermost
                if (!stack.isEmpty()) {
                    result.append(c);
                }
                stack.push(c);
            } else { // c == ')'
                stack.pop();
                // If stack is not empty after popping, this ')' is not outermost
                if (!stack.isEmpty()) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";

        System.out.println(sol.removeOuterParentheses(s1)); // Output: "()()()"
        System.out.println(sol.removeOuterParentheses(s2)); // Output: "()()()()(())"

        System.out.println(sol.removeOuterParenthesesStack(s1)); // Output: "()()()"
        System.out.println(sol.removeOuterParenthesesStack(s2)); // Output: "()()()()(())"
    }
}


/*
| Aspect          | Depth Counter Version               | Stack Version               |
| --------------- | ----------------------------------- | --------------------------- |
| **Speed**       | Faster (no object overhead)         | Slightly slower             |
| **Space Usage** | O(1) extra                          | O(n) worst-case (stack)     |
| **Simplicity**  | Very simple                         | Slightly more complex       |
| **Clarity**     | Very clear for counting parentheses | Clear but unnecessary stack |

✅ Winner: Depth Counter Version

When to use a stack?

Use a stack only when:

You need to store characters or indices for later use.

You’re matching different types of brackets (like {}, [], ()).

You need to retrieve content inside the parentheses.

For this problem, a stack is overkill.

*/