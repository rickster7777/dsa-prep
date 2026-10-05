/*
Example 1:
Input: n = 25

Output: 5

Explanation: The largest digit in 25 is 5.

Example 2:
Input: n = 99

Output: 9

Explanation: The largest digit in 99 is 9.

Example 3:
Input: n = 1

Output:
1

*/

class Solution {
    public int largestDigit(int n) {

        int max = 0;

        while( n!=0) {

            int digit = n % 10;

            max = Math.max(max, digit);

            n /= 10;
        }

        return max;
    }
}