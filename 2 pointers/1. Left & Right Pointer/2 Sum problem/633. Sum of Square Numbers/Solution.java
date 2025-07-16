class Solution {
    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = c - 1;

        while (start < end) {
            int product = start * start + end * end;
            if (product == c) {
                return true;
            } else if (product < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

     public boolean judgeSquareSumFixed(int c) {
        // if c = 5 then c/2 = 2
        // in case of division floor is considered

        int start = 0;
        int end = (int) Math.sqrt(c); //PTR

        while (start <= end) {
            long sum = (long) start * start + (long) end * end; //PTR

            if (sum == c) return true;
            else if (sum < c) start++;
            else end--;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int c = 5; // Example input
        boolean result = solution.judgeSquareSumFixed(c);
        System.out.println("Can " + c + " be expressed as the sum of two squares? " + result);
    }
}

/*
 * Problem: 633. Sum of Square Numbers
 * You are given a non-negative integer c.
 * Return true if there are two integers a and b such that a2 + b2 = c, or false otherwise.
 *
 * Example 1:
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: c = 3
 * Output: false

 * Issue with my above code is :
 * 1. it's not considering a case where a == b.
 * 2. It's not optimized as the loop is going till end - 1;
 */

