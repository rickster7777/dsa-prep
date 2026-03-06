/*
🧠 Core Intuition (One Sentence)
We track both max and min because:
A small negative product today can become a large positive product tomorrow.


🎯 Think of It Like This
At every index you ask:

"Is it better to:
Start fresh from this number?
Or extend previous max?
Or extend previous min (if negative flips sign)?"

*/
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If negative, swap max and min
            if (curr < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(curr, maxEnding * curr);
            minEnding = Math.min(curr, minEnding * curr);

            max = Math.max(max, maxEnding);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 2, 3, -2, 4 };
        System.out.println(solution.maxProduct(nums)); // Output: 6

        int[] nums1 = { -2, 0, -1 };
        System.out.println(solution.maxProduct(nums1)); // Output: 0

        int[] nums2 = { 2, -5, -2, -4, 3 }; // tricky case with multiple negatives illustrating the need to track both
                                            // max and min.
        System.out.println(solution.maxProduct(nums2)); // Output: 24
    }
}
