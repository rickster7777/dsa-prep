var generateParenthesis = function (n) {
    const result = [];

    // Backtracking function:
    // current -> the current combination of parentheses built so far
    // open -> number of '(' used
    // close -> number of ')' used
    const backtrack = (current, open, close) => {
        // 🛑 Base case: if the current string has reached the full length (n pairs → 2n characters)
        if (current.length === n * 2) {
            result.push(current); // ✅ Found a valid combination, add to result
            return;
        }

        // ✅ Choice 1: Add '(' if we still have some left
        if (open < n) {
            backtrack(current + '(', open + 1, close); // Make the choice, recurse
        }

        // ✅ Choice 2: Add ')' if it won't exceed the number of open brackets
        if (close < open) {
            backtrack(current + ')', open, close + 1); // Make the choice, recurse
        }

        // No need to undo (backtrack) the choice explicitly since strings are immutable and passed by value
    };

    // 🔁 Initial call to backtrack with empty path and 0 open/close
    backtrack('', 0, 0);

    // 📦 Return the final result array of all valid combinations
    return result;
};

console.log(generateParenthesis(3));



/*
backtrack("", 0, 0)
├── "(" → backtrack("(", 1, 0)
│   ├── "(" → backtrack("((", 2, 0)
│   │   ├── "(" → backtrack("(((", 3, 0)
│   │   │   └── ")" → backtrack("((()", 3, 1)
│   │   │       └── ")" → backtrack("((())", 3, 2)
│   │   │           └── ")" → backtrack("((()))", 3, 3) ✅ ✅
│   │   └── ")" → invalid (close > open)
│   └── ")" → backtrack("(()", 2, 1)
│       ├── "(" → backtrack("(()(", 3, 1)
│       │   └── ")" → backtrack("(()()", 3, 2)
│       │       └── ")" → backtrack("(()())", 3, 3) ✅ ✅
│       └── ")" → backtrack("(())", 2, 2)
│           └── "(" → backtrack("(())(", 3, 2)
│               └── ")" → backtrack("(())()", 3, 3) ✅ ✅
└── ")" → invalid (close > open)

backtrack("()", 1, 1)
├── "(" → backtrack("()(", 2, 1)
│   ├── "(" → backtrack("()((", 3, 1)
│   │   └── ")" → backtrack("()(()", 3, 2)
│   │       └── ")" → backtrack("()(()))", 3, 3) ✅ ✅
│   └── ")" → backtrack("()()", 2, 2)
│       └── "(" → backtrack("()()(", 3, 2)
│           └── ")" → backtrack("()()()", 3, 3) ✅ ✅


🧠 What’s Happening in the Call Stack?
Each recursive call represents one new character added (( or )):

It pushes a new frame onto the call stack

If it hits a base case (length = 2n), it adds that string to results

Then it backtracks — pops the stack — and explores another possibility

The call stack never goes deeper than 2n, and you backtrack automatically as the recursive function
returns.


Continue to learn and pay attention to AI Agent open source projects on GitHub (such as Auto-GPT, AgentGPT, LangGraph, etc.), 
and actively explore their application potential in actual business scenarios
*/