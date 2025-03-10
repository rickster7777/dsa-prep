package lcd;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1️⃣: Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {  // Only proceed if a valid decreasing element is found
            int j = n - 1;

            // Step 2️⃣: Find the next larger number to swap
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // Step 3️⃣: Reverse the right part to get the smallest lexicographical order
        reverse(nums, i + 1, n - 1);
    }

    // Helper function to swap two elements
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse the array from start to end
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};  // Example Input
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));  // Output: [1, 4, 2, 3, 5]
    }
}

