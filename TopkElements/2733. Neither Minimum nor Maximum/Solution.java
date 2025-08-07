import java.util.Arrays;

class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[1]; // This is guaranteed to be neither min nor max
    }


    public int findNonMinOrMaxBetterApproach(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }

        return -1; // If all numbers are either min or max (edge case)
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findNonMinOrMax(new int[]{3, 2, 1})); // Output: 2
        System.out.println(sol.findNonMinOrMax(new int[]{1, 2})); // Output: -1
        System.out.println(sol.findNonMinOrMax(new int[]{2, 2, 3, 1})); // Output: 2
    }
}
