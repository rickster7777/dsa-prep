public class Solution {
    public boolean increasingTriplet(int[] nums) {
        long first = Long.MAX_VALUE;  // Represents the smallest number
        long second = Long.MAX_VALUE; // Represents the second smallest number

        for (int num : nums) {
            if (num <= first) {
                first = num; // Update first if num is smaller or equal to first
            } else if (num <= second) {
                second = num; // Update second if num is smaller or equal to second
            } else {
                // If we find a num greater than both first and second, return true
                return true;
            }
        }

        return false; // No triplet found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(solution.increasingTriplet(nums1));  // Output: true

        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(solution.increasingTriplet(nums2));  // Output: false

        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println(solution.increasingTriplet(nums3));  // Output: true
    }
}
