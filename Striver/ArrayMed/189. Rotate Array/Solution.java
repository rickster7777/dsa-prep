
import java.util.Arrays;

/*
✅ Optimal Solution: Reverse Method (O(n) time, O(1) space)
Steps
Reverse the entire array
Reverse the first k elements
Reverse the remaining n - k elements

Example
nums = [1,2,3,4,5,6,7], k = 3

Reverse all:        [7,6,5,4,3,2,1]
Reverse first k:    [5,6,7,4,3,2,1]
Reverse rest:       [5,6,7,1,2,3,4]
*/

class Solution {
    // public static void rotate(int[] nums, int k) {

    // // This was the issue it create refrence it dosen't work like this
    // int[] numsCopy = nums;

    // int n = nums.length;

    // for (int i = 0; i < nums.length; i++) {

    // int index = i + k;

    // if (index < n) {
    // numsCopy[index] = nums[i];
    // } else {
    // int posIndex = n - index;
    // posIndex = Math.abs(posIndex);

    // numsCopy[posIndex] = nums[i];
    // }
    // }
    // nums = numsCopy;
    // }

    // Optimal Solution
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // making a copy approach
    public static void copyApproach(int[] nums, int k) {
        int n = nums.length;
        int[] copy = new int[n];

        for (int i = 0; i < n; i++)
            copy[(i + k) % n] = nums[i];

        for (int i = 0; i < n; i++)
            nums[i] = copy[i]; // writes back to caller-visible array

    }

    //
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        int k1 = 3; // expected [5,6,7,1,2,3,4]

        Solution.rotate(nums1, k1);

        System.out.println(Arrays.toString(nums1));

        // second test
        int[] nums2 = { -1, -100, 3, 99 };
        int k2 = 2; // expected [3,99,-1,-100]
        Solution.rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }
}