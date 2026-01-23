import java.util.HashMap;
import java.util.Map;
/*

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


*/
public class Solution {

/*
time complexity: O(n)
space complexity: O(n)
*/
public int numberOfSubarrays1(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            // Convert odd/even
            prefixSum += (num % 2);

            // Count subarrays ending here with k odds
            if (map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }

            // Store current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
}


    /*
    time complexity: O(n)
    space complexity: O(1)
    1. Use two pointers (left and right) to define the sliding window.
    2. Expand the window by moving the right pointer and count odd numbers.
    3. When the count of odd numbers equals k, calculate the number of nice subarrays
        by counting even numbers on both sides of the window.
    4. Move the left pointer to shrink the window and continue the process.
    5. Return the total count of nice subarrays found.
    */
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int oddCount = 0;
        int result = 0;
        int n = nums.length;

        while (right < n) {
            // Expand the window by moving the right pointer
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            // When we have exactly k odd numbers, calculate the number of nice subarrays
            if (oddCount == k) {
                int tempRight = right + 1;
                int rightEvenCount = 0;

                // Count even numbers to the right of the current window
                while (tempRight < n && nums[tempRight] % 2 == 0) {
                    rightEvenCount++;
                    tempRight++;
                }

                int tempLeft = left;
                int leftEvenCount = 0;

                // Count even numbers to the left of the current window
                while (tempLeft < n && nums[tempLeft] % 2 == 0) {
                    leftEvenCount++;
                    tempLeft++;
                }

                // The number of nice subarrays is determined by the combinations of even counts on both sides
                result += (leftEvenCount + 1) * (rightEvenCount + 1);

                // Move left pointer to shrink the window and reduce odd count
                while (left < n && nums[left] % 2 == 0) {
                    left++;
                }
                left++;
                oddCount--;
            }

            right++;
        }

        return result;
    }
}
