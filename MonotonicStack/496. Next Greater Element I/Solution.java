import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>(); // stores next greater for each element in nums2
        Deque<Integer> stack = new ArrayDeque<>(); // monotonic decreasing stack

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Maintain a decreasing stack
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // If stack is not empty, the top is the next greater element
            nextGreater.put(num, stack.isEmpty() ? -1 : stack.peek());

            // Push current element for future comparisons
            stack.push(num);
        }

        // Build the result for nums1 from the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }

    // Main method for quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        // nums1 is a subset of nums2
        // for all values in nums1 it's next element in nums2 is to be found.
        int[] result = sol.nextGreaterElement(nums1, nums2);
        System.out.println("Result: " + Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}
