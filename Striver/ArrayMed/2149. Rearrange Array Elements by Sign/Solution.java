/*
You should return the array of nums such that the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length / 2;

        // 1️⃣ Split positives and negatives (order preserved)
        int[] pos = new int[n];
        int[] neg = new int[n];

        int i = 0, j = 0;

        for (int num : nums) {
            if (num > 0) {
                pos[i] = num;
                i++;
            } else {
                neg[j] = num;
                j++;
            }
        }

        // 2️⃣ Merge them alternately
        i = 0;
        j = 0;

        for (int k = 0; k < nums.length; k++) {
            // positive at even index, negative at odd index
            if (k % 2 == 0) {
                nums[k] = pos[i];
                i++;
            } else {
                nums[k] = neg[j];
                j++;
            }
        }

        return nums;
    }

    public int[] rearrangeArrayOptimal(int[] nums) {
        int[] res = new int[nums.length];

        int posIndex = 0; // even indices
        int negIndex = 1; // odd indices
        // Fill positive numbers at even indices and negative numbers at odd indices
        // key idea: separate indices for pos and negatives and fill accordingly
        for (int num : nums) {
            if (num > 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        return res;
    }
}
