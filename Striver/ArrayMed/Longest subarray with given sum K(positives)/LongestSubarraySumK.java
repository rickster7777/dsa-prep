import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {

    public static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // To handle subarray starting from index 0
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // If (prefixSum - k) exists, we found a subarray
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            // Store only first occurrence
            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        // To test whyy map.put(0, -1) is necessary.
        // Without it, the below test case would return 0 instead of 2.
        int[] nums0 = {3, 1, 2};
        System.out.println(longestSubarray(nums0, 3)); // 2

        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(longestSubarray(nums, k)); // 4

        int[] nums1 = {10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarray(nums1, 15)); // 4

        int[] nums2 = {-3, 2, 1};
        System.out.println(longestSubarray(nums2, 6)); // 0
    }
}

