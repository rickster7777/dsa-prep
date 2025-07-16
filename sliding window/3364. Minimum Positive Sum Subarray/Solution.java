public class Solution {
    public static int minPositiveSumSubarray(int[] nums, int l, int r) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        // Step 1: Iterate over all possible subarray lengths from l to r
        for (int length = l; length <= r; length++) {
            int sum = 0;

            // Step 2: Compute sum of the first window (subarray) of current length
            for (int i = 0; i < length; i++) {
                sum += nums[i];
            }

            // Step 3: If the sum is positive, update minSum
            if (sum > 0) {
                minSum = Math.min(minSum, sum);
            }

            // Step 4: Slide the window through the array for the current length
            for (int i = length; i < n; i++) {
                sum += nums[i] - nums[i - length];

                // Step 5: If the sum is positive, update minSum
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        // Step 6: If no valid subarray found, return -1; otherwise, return minSum
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, -2, 1, 4};
        int l1 = 2, r1 = 3;
        System.out.println("Test Case 1: " + minPositiveSumSubarray(nums1, l1, r1)); // Output: 1

        // Test case 2
        int[] nums2 = {-2, 2, -3, 1};
        int l2 = 2, r2 = 3;
        System.out.println("Test Case 2: " + minPositiveSumSubarray(nums2, l2, r2)); // Output: -1

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        int l3 = 2, r3 = 4;
        System.out.println("Test Case 3: " + minPositiveSumSubarray(nums3, l3, r3)); // Output: 3
    }
}