
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

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 7, 5 };
        System.out.println(longestSubarrayPositive(nums1, 12)); // 2

        int[] nums2 = { 1, 2, 3, 4, 5 };
        System.out.println(longestSubarrayPositive(nums2, 9)); // 3

    }
}