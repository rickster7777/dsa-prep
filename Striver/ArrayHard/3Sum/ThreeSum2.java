import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 Example 1:
Input:
nums = [-1, 0, 1, 2, -1, -4]

Output:
[[-1, -1, 2], [-1, 0, 1]]

Example 2:
Input:
nums = [0, 0, 0, 0]

Output:
[[0, 0, 0]]

Example 3:
Input:
nums = [1, 2, -2, -1]

Output:
[]


✅ Validity Criteria for 3Sum:

The triplet must consist of three numbers that add up to 0.

Example: -1 + -1 + 2 = 0 ✅

The elements can be repeated values from the array, as long as their indices are different.

In this case, the array is [-1, -1, 2].

The first -1 is at index 0, the second at index 1, and 2 is at index 2.

All indices are distinct, so using both -1s is valid.

What the problem restricts is duplicate triplets, not duplicate values within a triplet.

For example, returning both [-1, -1, 2] and [-1, -1, 2] would be invalid (duplicate triplets).

But returning [-1, -1, 2] just once is valid.


if its avoiding duplicate triplets starting with the ssame number 

// Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Avoid duplicate triplets starting with the same number
            }

then why {-1, -1, 2} is a valid

🔍 What's being skipped, and what’s not?
The key idea:

We are skipping duplicate starting indices (i.e., duplicate i) in the outer loop, not skipping repeated values within the triplet.

So in this array:
nums = [-1, -1, 2]


After sorting: it's still [-1, -1, 2].

We loop over i:

✅ First iteration (i = 0):

nums[i] = -1

left = 1, right = 2

Triplet is: [-1, -1, 2]

It's valid:

All elements are from different indices: i=0, left=1, right=2

Their sum = 0

Triplet is added to the result.

❌ Second iteration (i = 1):

nums[i] = -1 (same as previous)

But now:

if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}


So this iteration is skipped to avoid recomputing the same triplet starting with the same -1.
Time Complexity: O(n^2) - The outer loop runs in O(n) and the inner while loop runs in O(n) in the worst case.
space Complexity: O(1) - We are using only a constant amount of extra space for the pointers and temporary variables.
*/
public class ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Traverse the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Avoid duplicate triplets starting with the same number
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

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

                } else if (sum < 0) {
                    left++; // Need a larger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum2 solution = new ThreeSum2();

        // Sample input
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        //-1, 0, 1 & -1, -1, 2

        int[] nums1 = {-1, -1, 0, 1};

        // Call the threeSum function
        List<List<Integer>> result = solution.threeSum(nums1);
        List<List<Integer>> result2 = solution.threeSum(nums);

        // Print the output
        System.out.println(result);
        System.out.println(result2);
    }
}
