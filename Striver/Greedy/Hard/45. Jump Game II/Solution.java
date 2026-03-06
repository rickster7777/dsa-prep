/*
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: [2,3,0,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last
*/

public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println(sol.jump(nums1)); // Output: 2

        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println(sol.jump(nums2)); // Output: 2
    }
}
