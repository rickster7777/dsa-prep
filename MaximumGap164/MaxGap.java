package MaximumGap164;

public class MaxGap {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        // STEP 1: Edge case: If the array contains less than 2 elements, return 0
        if (n < 2) {
            return 0;
        }

        // STEP 2: Find the minimum and maximum values manually
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // STEP 3: If the max value is equal to the min value, there is no gap
        if (minVal == maxVal) {
            return 0;
        }
        
        // STEP 4: Calculate the size of each bucket
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));

        // STEP 5: Number of buckets needed
        int bucketCount = ((maxVal - minVal) / bucketSize) + 1;

        // STEP 6: Create arrays for the buckets' min and max values
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize the buckets with appropriate values
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Place each number in the appropriate bucket
        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            if (num < bucketMin[index]) {
                bucketMin[index] = num;
            }
            if (num > bucketMax[index]) {
                bucketMax[index] = num;
            }
        }

        // Now find the maximum gap
        int maxGap = 0;
        int prevMax = minVal;

        // Check the gap between the maximum of the previous bucket and the minimum of
        // the current bucket
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
        MaxGap solution = new MaxGap();

        int[] nums1 = { 3, 6, 9, 1 };
        System.out.println("MG"+solution.maximumGap(nums1)); // Output: 3

        int[] nums2 = { 10 };
        System.out.println("MG"+solution.maximumGap(nums2)); // Output: 0
    }

}
