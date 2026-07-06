package lcd.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // core logic for finding all unique triplets that sum to zero
    // The approach is to sort the array and then use a two-pointer technique to find pairs that sum to the negative of 
    // the current element.

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting is required for the two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate numbers for i
            // since its sorted duplicates will be adjacent, so we can skip them to avoid duplicate triplets in the result.

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Move `start` and `end` while skipping duplicates
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    // Move both pointers after finding a valid triplet
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++; // Increase sum
                } else {
                    end--; // Decrease sum
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, - 1, -4 };
        System.out.println(threeSum(nums)); // Output: [[-1, -1, 2], [-1, 0, 1]]
        // Explanation: The triplets that sum to zero are (-1, -1, 2) and (-1, 0, 1).
        // Note: The order of the triplets and the order of numbers within each triplet may vary.
        // The solution ensures that there are no duplicate triplets in the output.
        // -1 is used twice in the first triplet, but it's considered a valid triplet because it appears 
        // in different positions in the array.
        // -1 is used once in the second triplet, and 0 and 1 are used once each.
        // same number can be used multiple times in different triplets as long as the triplet itself is unique.
    }
}
