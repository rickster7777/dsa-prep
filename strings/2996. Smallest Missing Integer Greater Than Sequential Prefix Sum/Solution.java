/*
Example 1:

Input: nums = [1,2,3,2,5]
Output: 6
Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array, therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.
Example 2:

Input: nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.

My Approach:

public int missingInteger(int[] nums) {
        int seq = nums[0];
        int i = 1;
        while(i < nums.length){

            if(nums[i] != nums[i - 1] + 1){
                break;
            }
            seq += nums[i];
            i++;
        }

        while(i < nums.length){
            seq = Math.max(seq, nums[i]);
            i++;
        }

        return seq + 1;

    }


*/

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int smallestMissingInteger(int[] nums) {
        // Step 1: Find the longest sequential prefix and its sum
        int n = nums.length;
        int longestPrefixSum = 0;
        int currentSum = 0;
        int i = 0;

        // Find the longest sequential prefix
        while (i < n) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                currentSum += nums[i];
                longestPrefixSum = currentSum;
                i++;
            } else {
                break;
            }
        }

        // Step 2: Find the smallest missing integer greater than or equal to the sum of the longest sequential prefix
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        // Start checking from the longest sequential prefix sum
        int x = longestPrefixSum;
        while (numsSet.contains(x)) {
            x++;
        }

        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1:
        int[] nums1 = {1, 2, 3, 2, 5};
        System.out.println(solution.smallestMissingInteger(nums1));  // Output: 6

        // Example 2:
        int[] nums2 = {3, 4, 5, 1, 12, 14, 13};
        System.out.println(solution.smallestMissingInteger(nums2));  // Output: 15
    }
}
