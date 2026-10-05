package strings.640. Solve the Equation;
/*
My approach:
1. split it on =
2. no of x and digits with the sign on each side
3. move digits to right and x to left.

I'm not sure this will work because there's no sample input for the "No Solution" case

blocker how 2x an 3x will be added/subtracted and sign manage.

Input:
"2x+3x-6x=x+2"

Let's simplify:

2x + 3x - 6x = x + 2
-x = x + 2

This actually has a solution (x = -1), so this is NOT a no-solution case.

A correct No solution example is:

Input:
"x=x+2"

Simplify:

x = x + 2

Subtract x:

0 = 2

That's impossible.

Therefore:
Input:  "x=x+2"
Output: "No solution"
*/


/*

*/
class Solution {

    public String solveEquation(String equation) {

        String[] parts = equation.split("=");

        int[] left = parse(parts[0]);
        int[] right = parse(parts[1]);

        int leftX = left[0];
        int leftConstant = left[1];

        int rightX = right[0];
        int rightConstant = right[1];

        // Case 1: x has a unique value
        if (leftX != rightX) {
            int x = (rightConstant - leftConstant)
                    / (leftX - rightX);

            return "x=" + x;
        }

        // Case 2: No solution
        if (leftConstant != rightConstant) {
            return "No solution";
        }

        // Case 3: Infinite solutions
        return "Infinite solutions";
    }

    private int[] parse(String expression) {

        int xCoefficient = 0;
        int constant = 0;

        int i = 0;

        while (i < expression.length()) {

            int sign = 1;

            // Check + or -
            if (expression.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int number = 0;
            boolean hasNumber = false;

            // Read number
            while (i < expression.length()
                    && Character.isDigit(expression.charAt(i))) {

                number = number * 10
                       + (expression.charAt(i) - '0');

                hasNumber = true;
                i++;
            }

            // If followed by x
            if (i < expression.length()
                    && expression.charAt(i) == 'x') {

                // "x" means coefficient 1
                if (!hasNumber) {
                    number = 1;
                }

                xCoefficient += sign * number;
                i++;

            } else {
                // Normal constant
                constant += sign * number;
            }
        }

        return new int[]{xCoefficient, constant};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String equation1 = "x+5-3+x=6+x-2";
        System.out.println(solution.solveEquation(equation1)); // Output: x=2

        String equation2 = "x=x";
        System.out.println(solution.solveEquation(equation2)); // Output: Infinite solutions

        String equation3 = "2x=x";
        System.out.println(solution.solveEquation(equation3)); // Output: x=0

        String equation4 = "2x+3x-6x=x+2";
        System.out.println(solution.solveEquation(equation4)); // Output: x=-1

        String equation5 = "x=x+2";
        System.out.println(solution.solveEquation(equation5)); // Output: No solution
    }
}

/*
Yes. If you're specifically trying to build **expression parsing/evaluation skills**, there is a useful progression of LeetCode problems.

### 🟢 Start here — basic expression evaluation

| #       | Problem                          | Main skill                              |
| ------- | -------------------------------- | --------------------------------------- |
| **224** | Basic Calculator                 | `+`, `-`, parentheses, stack            |
| **227** | Basic Calculator II              | `+`, `-`, `*`, `/`, operator precedence |
| **772** | Basic Calculator III             | `+`, `-`, `*`, `/`, parentheses         |
| **150** | Evaluate Reverse Polish Notation | Stack-based expression evaluation       |
| **640** | Solve the Equation               | Parsing `x` terms and constants         |

### 🟡 Next level — parsing strings into expressions

| #       | Problem               | Main skill                     |
| ------- | --------------------- | ------------------------------ |
| **385** | Mini Parser           | Nested expressions / recursion |
| **394** | Decode String         | Nested structures + stack      |
| **726** | Number of Atoms       | Parsing nested expressions     |
| **736** | Parse Lisp Expression | Recursive expression parsing   |

### 🔴 More advanced expression parsing

| #        | Problem                           | Main skill                     |
| -------- | --------------------------------- | ------------------------------ |
| **282**  | Expression Add Operators          | Generate possible expressions  |
| **241**  | Different Ways to Add Parentheses | Recursive expression splitting |
| **1106** | Parsing A Boolean Expression      | Boolean expression parsing     |
| **1096** | Brace Expansion II                | Complex expression parsing     |

### Recommended order for you

Since you just did **640**, I would go:

```text
640  Solve the Equation
   ↓
150  Evaluate Reverse Polish Notation
   ↓
227  Basic Calculator II
   ↓
224  Basic Calculator
   ↓
394  Decode String
   ↓
385  Mini Parser
   ↓
772  Basic Calculator III
   ↓
736  Parse Lisp Expression
   ↓
241  Different Ways to Add Parentheses
```

This progression teaches you several different ways of thinking about expressions:

```text
640
↓
Parse tokens

150
↓
Use stack to evaluate

227
↓
Handle operator precedence

224
↓
Handle parentheses

385 / 394
↓
Handle nesting

772
↓
Combine all of the above
```

If your goal is **Java interview preparation**, I'd particularly focus on **150 → 227 → 224 → 772**. These four give you a very good foundation in expression parsing.


*/