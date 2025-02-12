package MaximumGap164;
import java.util.Arrays;


class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);

        if (nums.length < 2) {
            return 0;
        }

        int value = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > value) {
                value = nums[i] - nums[i - 1];
            }
        }
        return value;
    }
}