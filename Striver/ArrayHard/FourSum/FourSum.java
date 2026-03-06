import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Time Complexity: O(n^3) - The outer two loops run in O(n^2) and the inner while loop runs in O(n) in the worst case.
space Complexity: O(1) - We are using only a constant amount of extra space for the pointers and temporary variables.
The output list does not count towards space complexity as it is required to store the results.
*/
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Traverse the array
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values for the first element of the quadruplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Avoid duplicate quadruplets starting with the same number
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicate values for the second element of the quadruplet
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Avoid duplicate quadruplets starting with the same second number
                }

                int left = j + 1;
                int right = nums.length - 1;

                // Step 3: Two-pointer approach
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Found a quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Move both pointers after processing the current pair
                        left++;
                        right--;

                    } else if (sum < target) {
                        left++; // Need a larger number
                    } else {
                        right--; // Need a smaller number
                    }
                }
            }
        }

        return result;
    }
}

