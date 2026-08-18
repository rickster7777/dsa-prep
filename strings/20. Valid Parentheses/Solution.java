import java.util.Stack;
class Solution {

    public boolean isValid(String s) {
        // STEP 1: Check for null or empty string
        if (s == null || s.length() == 0) {
            return true;
        }
        // STEP 1.1: If the length of the string is odd, it cannot be valid
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        /*
        While Stack is correct and commonly used in learning and coding interviews (such as LeetCode), in modern Java it's 
        generally recommended to use the Deque interface with an ArrayDeque implementation because it's faster 
        and Stack is a legacy class.

        Deque<Character> stack = new ArrayDeque<>();
        You use it in the same way:

        stack.push('A');
        stack.pop();
        stack.peek();
        */
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty or top of stack does not match the closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


/*
Suppose I want to remember this forever So how can you put this in words

🧠 One-Line Memory Rule (This is the key)
“Every closing bracket must close the most recent unmatched opening bracket.”
That single sentence explains why a stack is used.

🧠 The Story You Should Remember
Imagine brackets are plates.
Opening brackets → put a plate on the stack
Closing brackets → remove the top plate and check if it matches

Why?
Because the last opened bracket must be closed first (LIFO).
That is exactly what a stack does.

🧩 Step-by-Step Logic in Words

1. Odd length can never be valid
    → brackets come in pairs.

2. Scan the string from left to right

    If it’s an opening bracket ( { [
        👉 push it onto the stack

    If it’s a closing bracket ) } ]
        👉 pop the stack and check:
            Stack empty? ❌ invalid
            Mismatch? ❌ invalid

3. At the end
    Stack empty → ✅ all brackets matched
    Stack not empty → ❌ some brackets never closed

🧠 Ultra-Short Interview Explanation
“I use a stack because brackets must close in reverse order of opening.
I push opening brackets, and for each closing bracket I pop and validate.
If at any point there’s a mismatch or the stack is empty, it’s invalid.
Finally, the stack must be empty.”

That’s a perfect answer.
*/