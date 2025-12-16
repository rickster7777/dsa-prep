/*
Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;   // Stores the maximum consecutive 1s found
        int currentCount = 0; // Counts current consecutive 1s

        for (int num : nums) {
            if (num == 1) {
                currentCount++;                 // Extend the current streak
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;               // Reset when 0 is found
            }
        }

        return maxCount;
    }
}
