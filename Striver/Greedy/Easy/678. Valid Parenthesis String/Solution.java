import java.util.ArrayDeque;
import java.util.Deque;
/*
Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true

'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
*/
class Solution {
    // My Solution
    public boolean checkValidString(String s) {

        int count_open = 0, count_close = 0, count_asterik = 0;

        for (char a : s.toCharArray()) {

            if (a == '(') {
                count_open++;
            } else if (a == ')') {
                count_close++;
            } else {
                count_asterik++;
            }

        }

        int diff = count_open - count_close;

        if (diff == 0) {
            return true;
        } else if (Math.abs(diff) == count_asterik) {
            return true;
        }
        return false;
    }

    // Optimized Correct Solution
    /*
     * ✅ Correct Greedy Approach (Optimal – O(n), O(1))
     * 
     * Instead of counting totals, track a range of possible open parentheses:
     * low → minimum possible open brackets
     * high → maximum possible open brackets
     * 
     * Rules while iterating:
     * 
     * '(' → low++, high++
     * ')' → low--, high--
     * '*' →
     * could be ( → high++
     * could be ) → low--
     * could be empty → no change
     * 
     * So:
     * low--
     * high++
     * 
     * If at any time high < 0 → too many ) → return false
     * Keep low at minimum 0 (because we can't have negative opens)
     * 
     * At the end:
     * If low == 0 → valid
     * Else → invalid
     */
    public boolean checkValidStringOp(String s) {
        int low = 0; // minimum open parentheses
        int high = 0; // maximum open parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--; // if '*' acts as ')'
                high++; // if '*' acts as '('
            }

            if (high < 0)
                return false; // too many ')'

            if (low < 0)
                low = 0; // can't be negative
        }

        return low == 0;
    }

    // Optimized Correct Solution (Using Stack)
    /*
    🔎 Algorithm

Traverse the string.

If '(' → push index to openStack

If '*' → push index to starStack

If ')':

If openStack not empty → pop from openStack

Else if starStack not empty → pop from starStack

Else → return false

After traversal:

We may still have unmatched '('

Try to match remaining '(' with later '*'

If openIndex > starIndex → invalid (because * must come after ()

Else → pop both

If any '(' remains → return false
Otherwise → return true
    */
    public boolean checkValidStringStack(String s) {
        // Stack<Integer> openStack = new Stack<>();
        // Stack<Integer> starStack = new Stack<>();

        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else { // ')'
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*'
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                return false;
            }
            openStack.pop();
            starStack.pop();
        }

        return openStack.isEmpty();
    }
}