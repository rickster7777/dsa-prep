/*
Example 1:

Input: nums = [3,5,9], queries = [[1,-2],[0,-3]]

Output: 21

Explanation:
After the 1st query, nums = [3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 3 + 9 = 12.
After the 2nd query, nums = [-3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 9.

Example 2:

Input: nums = [0,-1], queries = [[0,-5]]

Output: 0

Explanation:
After the 1st query, nums = [-5,-1] and the maximum sum of a subsequence with non-adjacent elements is 0 (choosing an empty subsequence).
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        // for (int i = 0; i < queries.length; i++) {
        // map.put(queries[i][0], queries[i][1]);
        // }

        for (int i = 0; i < queries.length; i++) {

            if (i < queries.length) {
                int idx = queries[i][0];
                int val = queries[i][1];
                nums[idx] = val;

                if ((idx + 1) < nums.length) {
                    sum += nums[idx + 1];
                }

                if ((idx - 1) >= 0) {
                    sum += nums[idx - 1];
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 9 };
        int[][] queries = { { 1, -2 }, { 0, -3 } };

        System.out.println(maximumSumSubsequence(nums, queries));
    }
}
