/*
Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.


Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.


Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
*/

class Solution {
    public int findMin(int[] nums) {

        if (nums.length <= 1)
            return nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    // My above solution works completely fine but its not running in logarithmic time It is performing a linear Search.

    public int findMinBinary(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }
}

