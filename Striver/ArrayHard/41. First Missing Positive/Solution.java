
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Although it rearranges the array, it is not comparison-based sorting. Instead, it's an in-place
            // index-placement (cyclic sort) technique specialized for arrays containing values in the range 1 to n.
            // Continue swapping until:
            // 1. The number is positive.
            // 2. The number is within the array range (1 to n).
            // 3. It is not already in its correct position.
            while (nums[i] > 0 &&
                    nums[i] <= n &&
                    nums[nums[i] - 1] != nums[i]) {

                // Correct index where nums[i] belongs
                int correctIndex = nums[i] - 1;

                // Swap nums[i] with the element at its correct position

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    /*
     * Complexity
     * Time: O(n)
     * Extra Space: O(1)
     * 
     * This "put value x at index x-1" pattern is often called cyclic sort and
     * appears in
     * several array interview problems.
     */
}
