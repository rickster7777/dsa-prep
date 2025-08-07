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

    /*
     * 
     * 🧪 Example Walkthrough:
     * int[] nums = {3, -2, 1, 4};
     * int l = 2, r = 3;
     * So we are looking for positive-sum subarrays of length 2 or 3.
     * 🔍 Step-by-step:
     * ✅ Length = 2:
     * Subarray from index 0 to 1:
     * {3, -2} → sum = 1 → positive → minSum = 1
     * 
     * Subarray from index 1 to 2:
     * {-2, 1} → sum = -1 → not positive → skip
     * 
     * Subarray from index 2 to 3:
     * {1, 4} → sum = 5 → positive → minSum stays 1
     * 
     * ✅ Length = 3:
     * Subarray from index 0 to 2:
     * {3, -2, 1} → sum = 2 → positive → minSum stays 1
     * 
     * Subarray from index 1 to 3:
     * {-2, 1, 4} → sum = 3 → positive → minSum stays 1
     */
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 3, -2, 1, 4 };
        int l1 = 2, r1 = 3;
        System.out.println("Test Case 1: " + minPositiveSumSubarray(nums1, l1, r1)); // Output: 1

        // Test case 2
        int[] nums2 = { -2, 2, -3, 1 };
        int l2 = 2, r2 = 3;
        System.out.println("Test Case 2: " + minPositiveSumSubarray(nums2, l2, r2)); // Output: -1

        // Test case 3
        int[] nums3 = { 1, 2, 3, 4 };
        int l3 = 2, r3 = 4;
        System.out.println("Test Case 3: " + minPositiveSumSubarray(nums3, l3, r3)); // Output: 3
        /*
         * We need to find the minimum positive sum among all subarrays of length 2, 3,
         * or 4.
         * 🔍 Step-by-step Processing:
         * ✅ Subarrays of length = 2:
         * We slide a window of size 2 over the array:
         * [1, 2] → sum = 3 ✅
         * [2, 3] → sum = 5 ✅
         * [3, 4] → sum = 7 ✅

         * ✔️ All positive → current minSum = 3
         * ✅ Subarrays of length = 3:
         * [1, 2, 3] → sum = 6 ✅
         * [2, 3, 4] → sum = 9 ✅
         * ✔️ All positive → minSum remains 3

         * ✅ Subarray of length = 4:
         * [1, 2, 3, 4] → sum = 10 ✅
         * ✔️ Positive → minSum still 3
         */
    }
}