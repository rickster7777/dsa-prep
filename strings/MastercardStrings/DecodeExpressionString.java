/*
This expression is the key in this problem and also in general for parsing numbers from strings:
count = count * 10 + (s.charAt(i) - '0');
*/

public class DecodeExpressionString {

    public static void main(String[] args) {
        String s = "6[2*3]5[2+2]3[2-2]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {

            // 1. Parse repetition count
            int count = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                /*
                 * ✔ Works for any number of digits (single-digit or multi-digit)
                 * ✔ Correctly parses values such as 0–9, 10–99, 100+, and beyond
                 * ✔ This is a standard, interview-approved technique for converting characters
                 * to numbers
                 * ⚠ The only limitation is the range of Java’s int type (overflow if the value
                 * exceeds 2,147,483,647)
                 */
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }

            // Skip '['
            i++;

            // 2. Extract expression inside brackets
            StringBuilder expr = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ']') {
                expr.append(s.charAt(i));
                i++;
            }

            // Skip ']'
            i++;

            // 3. Evaluate expression
            int value = evaluateExpression(expr.toString());

            // 4. Append value count times
            for (int j = 0; j < count; j++) {
                result.append(value);
            }
        }

        return result.toString();
    }

    // Evaluates expressions like "2+3", "4*5", "6-2"
    private static int evaluateExpression(String expr) {
        int num1 = 0, num2 = 0;
        char operator = '+';
        int i = 0;

        // Parse first number
        while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
            num1 = num1 * 10 + (expr.charAt(i) - '0');
            i++;
        }

        // Operator
        operator = expr.charAt(i);
        i++;

        // Parse second number
        while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
            num2 = num2 * 10 + (expr.charAt(i) - '0');
            i++;
        }

        // Apply operation
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }

        return 0;
    }
}
