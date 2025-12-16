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
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarray(nums1, 15)); // 4

        int[] nums2 = {-3, 2, 1};
        System.out.println(longestSubarray(nums2, 6)); // 0
    }
}
