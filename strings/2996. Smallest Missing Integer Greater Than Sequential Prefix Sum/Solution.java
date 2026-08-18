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
        int currentSum = 0;
        int i = 0;
        /*
        In problem statement this is given
        A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular,
        the prefix consisting only of nums[0] is sequential.
        */
        // Find the longest sequential prefix
        while (i < n) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                currentSum += nums[i];
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
        int x = currentSum;
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
        // explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 
        // 6 is not in the array, therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.

        // Example 2:
        int[] nums2 = {3, 4, 5, 1, 12, 14, 13};
        System.out.println(solution.smallestMissingInteger(nums2));  // Output: 15
        // explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. 
        // Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.

        /*
        In example 2 why sum is 3, 4, 5 and not 12, 13, 14 ?

        A consecutive prefix means:

        you start from the beginning of the array
        take elements one by one
        each next element must be exactly 1 more than the previous one
        Example:
\
        [1, 2, 3, 4] → this is a consecutive prefix
        [3, 4, 5] → this is also a consecutive prefix
        [2, 4, 5] → this is not, because 4 is not 1 more than 2
        So for an array like:

        [3, 4, 5, 1, 12, 14, 13]
        the consecutive prefix is:

        3, 4, 5
        because:

        4 is 1 more than 3
        5 is 1 more than 4
        But once it reaches 1:

        1 is not 1 more than 5
        So the prefix stops there.

        In simple words
        A consecutive prefix is the longest starting chunk of the array where numbers increase by 1 each time.

        Important part
        After finding that prefix, you compute its sum:

        3 + 4 + 5 = 12
        3+4+5=12
        Then you check from 12 upward to find the first missing number. Since 12, 13, 14 are present, the answer is 15.

        {3, 4, 5, 1, 15, 14, 13};
        what will be the out put now ?

        Its sum is:
        Now we check from 12 upward:

        12 is not present
        so the answer is 12
        ✅ Output: 12
        */
    }
}
