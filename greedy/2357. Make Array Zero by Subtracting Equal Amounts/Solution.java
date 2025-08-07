/*
Example 1:

Input: nums = [1,5,0,3,5]
Output: 3
Explanation:
In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
Example 2:

Input: nums = [0]
Output: 0
Explanation: Each element in nums is already 0 so no operations are needed.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperationsBrute(int[] nums) {
        int operations = 0;

        while (true) {
            int min = Integer.MAX_VALUE;

            // Step 1: Find the smallest non-zero element
            for (int num : nums) {
                if (num > 0) {
                    min = Math.min(min, num);
                }
            }

            // If no non-zero found, we're done
            if (min == Integer.MAX_VALUE)
                break;

            // Step 2: Subtract min from every positive number
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= min;
                }
            }

            // Step 3: Count this operation
            operations++;
        }

        return operations;
    }

    // Mathematical technique
    /*
     * 📌 So, to answer your question:
     * Is it some kind of mathematical logic?
     * 
     * ✅ Yes. It’s based on the idea that each distinct non-zero value in the array
     * will be eliminated in a separate operation.
     * 
     * No need to simulate every subtraction — just count unique positive values.
     */
    public int minimumOperations(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.contains(num) && num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}