package disappearednumbers;

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Mark visited numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Convert number to 0-based index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited (negative)
            }
        }

        // Step 2: Collect missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // If positive, index + 1 is missing
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers(nums1)); // Output: [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(solution.findDisappearedNumbers(nums2)); // Output: [2]
    }
}
