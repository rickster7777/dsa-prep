import java.util.Arrays;

/*
Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]

Explanation:
- avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
- The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
Using integer division, avg[3] = 37 / 7 = 5.
- For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
- For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
- avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.
*/

/*
❓ What is a k-radius average?
For a given index i, the k-radius average is the average of all elements from index i - k to i + k, inclusive.
So, for a window size of 2k + 1, the average is only computed if there are enough elements on both sides.

Why does the window size equal 2k + 1?
For any index i, a k-radius average includes:
k elements to the left of i → from i - k
1 element at index i itself
k elements to the right of i → up to i + k
So the total number of elements in this window is:
end - start + 1 = 2k + 1
*/

public class KRadiiAverages {
    /**
     * Calculates the k-radius averages for each index in the array.
     * If there are not enough elements on either side, returns -1 for that index.
     *
     * Steps:
     * 1. Handle edge case where k == 0 (each element is its own average).
     * 2. Calculate window size (2k + 1).
     * 3. If window size is greater than array length, return all -1.
     * 4. Compute the sum of the initial window.
     * 5. Slide the window across the array, updating the sum and averages.
     * 6. Return the result array.
     */
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1); // Step 1: Initialize all averages to -1

        // Step 2: Handle edge case where k == 0
        if (k == 0)
            return nums;

        int windowSize = 2 * k + 1; // Step 3: Calculate window size

        // Step 4: If window size is greater than array length, return all -1
        if (windowSize > n)
            return avgs;

        long windowSum = 0;

        // Step 5: Compute the sum of the initial window
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        avgs[k] = (int) (windowSum / windowSize); // First valid average at index k

        // Step 6: Slide the window and compute averages for each valid center
        for (int i = k + 1; i < n - k; i++) {
            // Remove the element leaving the window and add the new element entering
            windowSum = windowSum - nums[i - k - 1] + nums[i + k];
            avgs[i] = (int) (windowSum / windowSize);
        }

        // Step 7: Return the result array
        return avgs;
    }

    public static void main(String[] args) {
        KRadiiAverages obj = new KRadiiAverages();
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        System.out.println(Arrays.toString(obj.getAverages(nums, k)));
        // Output: [-1, -1, -1, 5, 4, 4, -1, -1, -1]
    }
}
