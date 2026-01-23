/*
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
*/

/*
Every number appears twice except one
    XOR helps because:
    x ^ x = 0
    x ^ 0 = x
*/
public class Solution {
    public static int singleNumber(int[] nums) {
        int result = 0;

        // XOR all numbers in the array
        for (int num : nums) {
            result ^= num; // XOR operation
        }

        return result; // The result is the single number
    }

    public static void main(String[] args) {
        // int[] nums1 = { 2, 2, 1 };
        // System.out.println(singleNumber(nums1)); // Output: 1

        int[] nums2 = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums2)); // Output: 4

        int[] nums3 = { 1 };
        System.out.println(singleNumber(nums3)); // Output: 1
    }
}


/*
int[] nums2 = { 4, 1, 2, 1, 2 };

| Iteration | num | result before | result after |
| --------- | --- | ------------- | ------------ |
| 1         | 4   | 0             | 4            |
| 2         | 1   | 4             | 5            |
| 3         | 2   | 5             | 7            |
| 4         | 1   | 7             | 6            |
| 5         | 2   | 6             | 4            |

*/