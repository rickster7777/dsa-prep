/*
This is the most efficient way to remove duplicates from a sorted array in-place, and it matches the optimal solution used in LeetCode 26.

Why this is optimal
Time Complexity: O(n) → single pass
Space Complexity: O(1) → no extra memory
Uses the two-pointer technique
Maintains the order of elements
Modifies the array in-place as required


How It Works (Quick Explanation)
Because the array is sorted, all duplicates are adjacent
uniqueIndex tracks where the next unique value should go
i scans through the array
When a new value is found, it is copied forward
The first uniqueIndex + 1 elements of nums contain all unique values
*/



class Solution {
    public int removeDuplicates(int[] nums) {

        // Index of the last unique element found
        int uniqueIndex = 0;

        // Start from the first element and scan the array
        for (int i = 0; i < nums.length; i++) {

            // If the current element is different from the last unique element
            if (nums[i] != nums[uniqueIndex]) {

                // Move the unique index forward
                uniqueIndex++;

                // Update the array with the new unique element
                nums[uniqueIndex] = nums[i];
            }
        }

        // Number of unique elements is uniqueIndex + 1
        return uniqueIndex + 1;
    }

    // Hardcoded test harness with sample inputs
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Sample test cases
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {1};
        int[] nums4 = {1, 2, 3, 4, 5};


        System.out.println(solver.removeDuplicates(nums1));

        System.out.println(solver.removeDuplicates(nums2));

        System.out.println(solver.removeDuplicates(nums3));

        System.out.println(solver.removeDuplicates(nums4));

    }
}
