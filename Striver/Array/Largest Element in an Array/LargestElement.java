/*

The most efficient way to find the largest element in an array is a single linear scan.

✅ Best & Optimal Approach (Linear Scan)
⏱ Time Complexity

O(n) → You must look at every element at least once
(this is provably optimal)

💾 Space Complexity

O(1) → No extra space
*/

public class LargestElement {
    public static int findLargest(int[] nums) {
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
    }
    return max;
}

}
