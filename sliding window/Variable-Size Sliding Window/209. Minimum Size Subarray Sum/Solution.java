public class Solution {
    /**
     * Returns the minimal length of a contiguous subarray of which the sum is at least target.
     * Uses the sliding window technique to efficiently find the answer in O(n) time.
     *
     * @param target the target sum to reach or exceed
     * @param nums the input array of positive integers
     * @return the minimal length of a qualifying subarray, or Integer.MAX_VALUE if none exists
     */
    public int minSubArray(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window by moving 'right' and add nums[right] to sum
        while (right < n) {
            sum += nums[right];

            // Shrink the window from the left as long as the sum is >= target
            while (sum >= target) {
                // Update the minimum length if current window is smaller
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left]; // Remove the leftmost element
                left++;            // Move left pointer forward
            }
            right++;
        }
        return minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 0;
        int result = solution.minSubArray(target, nums);
        System.out.println("Minimum length of subarray with sum >= " + target + " is: " + result);
    }
}