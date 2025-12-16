
public class longestSubarrayPositive {
    public static int longestSubarrayPositive(int[] nums, int k) {
    int left = 0, sum = 0, maxLen = 0;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum > k) {
            sum -= nums[left++];
        }

        if (sum == k) {
            maxLen = Math.max(maxLen, right - left + 1);
        }
    }
    return maxLen;
}

}
