
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum_n = n * (n + 1) / 2;

        int sum_nums = 0;
        for (int num : nums) {
            sum_nums += num;
        }

        return sum_n - sum_nums;
    }

    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        int[] nums1 = { 3, 0, 1 }; // expected: 2
        int[] nums2 = { 0, 1 }; // expected: 2
        int[] nums3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 }; // expected: 8
        int[] nums4 = { 0 }; // expected: 1

        System.out.println("Input: nums = [3,0,1] -> Output: " + solver.missingNumber(nums1));
        System.out.println("Input: nums = [0,1] -> Output: " + solver.missingNumber(nums2));
        System.out.println("Input: nums = [9,6,4,2,3,5,7,0,1] -> Output: " + solver.missingNumber(nums3));
        System.out.println("Input: nums = [0] -> Output: " + solver.missingNumber(nums4));
    }
}