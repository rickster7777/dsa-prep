/*
input : nums = [2,3,1,1,4]
output : true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

input : nums = [3,2,1,0,4]
output : false
explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to
reach the last index.
*/

public class Solution {
    public boolean canJump(int[] nums) {

        // My approach
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= nums.length) {
                return true;
            }

            int maxIndex = i;

            for (int j = i + 1; j <= nums[i]; j++) {

                if (nums[j] > nums[i]) {
                    maxIndex = j;
                }
            }

            if ((nums.length - 1) - maxIndex >= nums[maxIndex]) {
                return true;
            }

        }

        return false;
    }

    // Correct solution
    public boolean canJump1(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) // you're stuck before i
                return false;
            reach = Math.max(reach, i + nums[i]);
            if (reach >= nums.length - 1) // can reach or pass the end
                return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(sol.canJump(nums)); // Output: true
        System.out.println(sol.canJump(new int[] { 3, 2, 1, 0, 4 })); // Output: false
    }
}
