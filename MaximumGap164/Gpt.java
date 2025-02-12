package MaximumGap164;

import java.util.Arrays;

class Gpt {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        
        // Edge case: If the array contains less than 2 elements, return 0
        if (n < 2) {
            return 0;
        }
        
        // Find the minimum and maximum values in the array
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        
        // If the max value is equal to the min value, there is no gap
        if (minVal == maxVal) {
            return 0;
        }
        
        // Calculate the size of each bucket
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        
        // Number of buckets we need
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        
        // Create arrays for the buckets' min and max values
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        
        // Initialize the buckets with appropriate values
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // Place each number in the appropriate bucket
        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }
        
        // Now find the maximum gap
        int maxGap = 0;
        int prevMax = minVal;
        
        // Check the gap between the maximum of the previous bucket and the minimum of the current bucket
        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        
        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {3, 6, 9, 1};
        System.out.println(solution.maximumGap(nums1));  // Output: 3
        
        int[] nums2 = {10};
        System.out.println(solution.maximumGap(nums2));  // Output: 0
    }
}
