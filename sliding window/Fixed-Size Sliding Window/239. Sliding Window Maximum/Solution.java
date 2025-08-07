import java.util.*;

/*
 Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = k - 1, n = nums.length;

        List<Integer> result = new ArrayList<>();

        while (right < n) {

            int max = checkMax(nums, right, left);
            result.add(max);

            right++;
            left++;
        }
        int[] intArray = result.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }

    public int checkMax(int[] nums, int right, int left) {

        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {

            if (nums[i] > max) {
                max = nums[i];
            }

        }

        return max;
    }

    /*
     * Your code for solving the "Sliding Window Maximum" problem is functionally
     * correct but inefficient for large inputs. Here's an analysis:
     * ✅ What's Working
     * The sliding window logic using left and right pointers is correctly
     * implemented.
     * checkMax() correctly finds the max in the current window.
     * You're collecting the result properly in a list and converting it to an
     * array.
     * 
     * ⚠️ What's Wrong or Suboptimal
     * 1. Inefficient Time Complexity
     * You're recomputing the max in each window from scratch using a loop:
     * 
     * int max = checkMax(nums, right, left);
     * This takes O(k) time per window, and with n-k+1 windows, the overall time
     * complexity is O(n * k).
     * 
     * This will lead to Time Limit Exceeded (TLE) on large inputs like nums.length
     * = 10^5 and k = 50000.
     * 
     * ✅ What You Should Do Instead
     * Use a deque (double-ended queue) to keep track of indices of potential max
     * elements in the current window in O(n) time.
     * 
     */
    // 🔁 Efficient O(n) Approach Using Deque
    // Here's a corrected and optimized version of your code:
    public static int[] maxSlidingWindowQueue(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add to result from the front of deque (max in window)
            if (i >= k - 1) {
                // Operator precedence goes left to right here since all are the same
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(Solution.maxSlidingWindowQueue(nums, k)));
    }

}