/*
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

*/
class Solution {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            // Check which half is sorted
            if (nums[low] <= nums[mid]) {  // Left half is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            } else {  // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1;  // Search left
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

        int target = 0;

        int result = search(nums, target);

        System.out.println("Index of target " + target + ": " + result); // Output: 4
    }
}