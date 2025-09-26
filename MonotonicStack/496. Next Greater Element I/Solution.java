import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: Traverse nums2 to build next greater mapping
        for (int num : nums2) {


            while (!stack.isEmpty() && num > stack.peek()) {
                int top = stack.pop();
                nextGreaterMap.put(top, num); // Current num is next greater for top
            }


            stack.push(num);
        }

        // Step 2: Build result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2))); // Output: [-1, 3, -1]
    }
}

/*
Here’s how the output is computed for
int[] nums1 = {4, 1, 2};
int[] nums2 = {1, 3, 4, 2};

Step-by-step for each element in nums1:

4:
In nums2, 4 is at index 2.
The next element is 2, which is not greater than 4.
So, output is -1.

1:
In nums2, 1 is at index 0.
The next elements are 3, 4, 2.
The first greater element is 3.
So, output is 3.


2:
In nums2, 2 is at index 3 (last element).
There are no elements after 2.
So, output is -1.
Final Output:
[-1, 3, -1]




Sample Input 2:


nums1 = [2, 4]
nums2 = [1, 2, 3, 4]
Sample Output:
[3, -1]
 */