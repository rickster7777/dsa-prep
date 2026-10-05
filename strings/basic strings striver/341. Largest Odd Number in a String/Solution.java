/*
Example 1:
Input : s = "5347"

Output : "5347"

Explanation :

The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.

So the largest among all the possible odd numbers for given string is 5347.

Example 2:
Input : s = "0214638"

Output : "21463"

Explanation :

The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.

We cannot include 021463 as the number contains leading zero.

So largest odd number in given string is 21463.
*/
/*
This looks easy
But initially I was trying to do it by generating all the substrings

The algorithm
1. Find the rightmost odd digit.
2. If there isn't one → return "".
3. Find the first non-zero digit from the beginning.
4. Return the substring from that position through the rightmost odd digit.

There is one important edge case: if the string consists of zeros before a single odd digit, we must preserve
that odd digit rather than accidentally returning an empty string.
*/
class Solution {

    public String largeOddNum(String s) {

        int n = s.length();
        int start = 0;
        int end = n - 1;

        // Find the rightmost odd digit
        while (end >= 0 && (s.charAt(end) - '0') % 2 == 0) {
            end--;
        }

        // No odd number exists
        if (end == -1) {
            return "";
        }

        // Skip leading zeros
        while (start <= end && s.charAt(start) == '0') {
            start++;
        }

        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "5347";
        String s2 = "0214638";
        String s3 = "2468"; // No odd number

        System.out.println(solution.largeOddNum(s1)); // Output: "5347"
        System.out.println(solution.largeOddNum(s2)); // Output: "21463"
        System.out.println(solution.largeOddNum(s3)); // Output: ""
}
}
/*


*/