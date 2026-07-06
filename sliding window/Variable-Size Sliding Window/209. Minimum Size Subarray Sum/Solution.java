public class Solution {
    /**
     * Returns the minimal length of a contiguous subarray of which the sum is at
     * least target.
     * Uses the sliding window technique to efficiently find the answer in O(n)
     * time.
     *
     * @param target the target sum to reach or exceed
     * @param nums   the input array of positive integers
     * @return the minimal length of a qualifying subarray, or Integer.MAX_VALUE if
     *         none exists
     */
    public int minSubArray(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window by moving 'right' and add nums[right] to sum
        // TC: O(n) since each element is visited at most twice (once when added and once when removed)
        while (right < n) {
            sum += nums[right];

            // Shrink the window from the left as long as the sum is >= target
            while (sum >= target) {
                // Update the minimum length if current window is smaller
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left]; // Remove the leftmost element
                left++; // Move left pointer forward
            }
            right++;
        }
        return minLength;
    }


    // This approach has TC: O(n log n) due to the binary search,
    // and SC: O(n) for the prefix sum array.
    // So the above sliding window approach is more efficient for this problem.
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            long required = prefix[i] + target;

            int bound = lowerBound(prefix, required);

            if (bound != -1) {
                ans = Math.min(ans, bound - i);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int lowerBound(long[] arr, long target) {

        int left = 0;
        int right = arr.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 0;
        int result = solution.minSubArray(target, nums);
        System.out.println("Minimum length of subarray with sum >= " + target + " is: " + result);
    }
}