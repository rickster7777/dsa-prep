import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n / 2; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            max = Math.max(max, sum);
        }
        /*
         * which is same as
         * start = 0, end = n/2
         * while(start < end){
         * int sum = nums[start] + nums[end];
         * start++;
         * end--;
         * }
         */
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums1 = {3, 5, 2, 3};
        // System.out.println("Output: " + solution.minPairSum(nums1)); // Output: 7

        int[] nums2 = { 3, 5, 4, 2, 4, 6 };
        System.out.println("Output: " + solution.minPairSum(nums2)); // Output: 8
    }
}

/*
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the
 * largest pair sum in a list of pairs.
 * 
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum
 * would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2
 * pairs such that:
 * 
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 * Return the minimized maximum pair sum after optimally pairing up the
 * elements.
 * Example 1:
 * Input: nums = [3,5,2,3]
 * Output: 7
 * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
 * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 * 
 * Example 2:
 * Input: nums = [3,5,4,2,4,6]
 * Output: 8
 * Explanation: The elements can be paired up into pairs (3,5), (4,4), and
 * (6,2).
 * The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
 * 
 * 
 * Constraints:
 * n == nums.length
 * 2 <= n <= 105
 * n is even.
 * 1 <= nums[i] <= 105
 */