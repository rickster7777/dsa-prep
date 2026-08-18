/*
Algorithm:
1. Initialize two variables: `count` to keep track of the current depth of nested parentheses
    and `maxCount` to keep track of the maximum depth encountered so far.
2. Iterate through each character in the input string `s`.
   - If the character is '(', increment `count` and update `maxCount` if `count` exceeds `maxCount`.
   - If the character is ')', decrement `count`.
3. After processing all characters, return `maxCount` as the maximum nesting depth of the parentheses in the string.
*/
class Solution {
    public int maxDepth(String s) {

        int count = 0;
        int maxCount = 0;

        for(int i = 0; i < s.length(); i++) {

            if ( (s.charAt(i) != '(') && (s.charAt(i) != ')' )){

                continue;
            }

            if ( s.charAt(i) == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            }  else {
                count--;
            }
        }

        return maxCount;
    }

    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        String input1 = "()(())((()()))";      // expected: 3
        String input2 = "(1)+((2))+(((3)))";         // expected: 3
        String input3 = "1+(2)";                     // expected: 1

        System.out.println("Input: \"" + input1 + "\" -> Output: " + solver.maxDepth(input1));
        System.out.println("Input: \"" + input2 + "\" -> Output: " + solver.maxDepth(input2));
        System.out.println("Input: \"" + input3 + "\" -> Output: " + solver.maxDepth(input3));
    }
}