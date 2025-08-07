class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Calculate the sum of the first window of size k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize max with the first window's sum
        int max = sum;

        // Step 2: Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Add the next element and subtract the element that is leaving the window
            sum += nums[i] - nums[i - k];

            // Update the max sum
            max = Math.max(max, sum);
        }

        // Step 3: Return the average of the maximum sum window
        return (double) max / k;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 1, 3, 3};
        int k = 4;

        double result = solution.findMaxAverage(nums, k);
        System.out.println(result); // Output should be 2.0
    }
}