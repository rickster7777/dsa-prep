public class sample {

    static int evaluateExpression(String sb) {

        int i = 0;
        int num1 = 0;
        int num2 = 0;
        char expr = '\0';

        while (i < sb.length()) {

            while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
                num1 = num1 * 10 + (sb.charAt(i) - '0');
                i++;
            }

            expr = sb.charAt(i);
            i++;

            while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
                num2 = num2 * 10 + (sb.charAt(i) - '0');
                i++;
            }

            return switch (expr) {
                case '*' -> num1 * num2;
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '/' -> num1 / num2;
                default -> throw new IllegalArgumentException("Invalid operator");
            };

        }
        return -1;

    }

    public static void main(String[] args) {

        String s = "6[2*3]5[2+2]3[2-2]";

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (i < s.length()) {

            int count = 0;
            while (i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']') {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }

            if (i < s.length() && (s.charAt(i) == '[' || s.charAt(i) == ']')) {
                i++;
            }

            StringBuilder sb = new StringBuilder();

            while (i < s.length() && s.charAt(i) != ']') {
                sb.append(s.charAt(i));
                i++;
            }

            int expression = evaluateExpression(sb.toString());

            // result.repeat(count, expression);
            /*
            “The issue was that StringBuilder.repeat() treats the integer as a Unicode code point, so I had to convert the number to a string before repeating.”
            */
            result.append(String.valueOf(expression).repeat(count));
            i++;
            System.out.println(result);
        }
    }
}
