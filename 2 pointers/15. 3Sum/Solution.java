import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting is required for the two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicate numbers for i

            if (nums[i] > 0)
                break;
            /*
            This is used to stop the loop early if the current number nums[i] is greater than 0.
            Reason:
            Since the array is sorted, if nums[i] is positive, all numbers after it will also be positive.
            Three positive numbers cannot sum to zero, so there is no need to check further.
            This improves efficiency by avoiding unnecessary iterations.
             */
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Move `start` and `end` while skipping duplicates
                    while (start < end && nums[start] == nums[start + 1])
                        start++;
                    while (start < end && nums[end] == nums[end - 1])
                        end--;

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
}