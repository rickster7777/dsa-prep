/*

Example 1:
Input: nums = [1,0,1,0,1], goal = 2

Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]


Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15


My approach: To
find all the subarrays having sum equal and check if it is equal to k
using recursion and backtracking.

correct approach: Sliding window approach.

Steps to remember:
1. Use two pointers (left and right) to define the window.
2. Expand the window by moving the right pointer and include elements.
3. Keep track of the count of 1's in the current window.
4. If the count of 1's exceeds the goal, shrink the window from the left until it is valid.
5. For each valid window, add the number of subarrays ending at right to the result.
6. The window always contains at most 'goal' number of 1's.

Time Complexity: O(n) where n is the length of the array.
Space Complexity: O(1) as we are using constant space.
*/
public class Solution {
    int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }
    int atMostK(int[] nums, int k) {
        int left = 0, right = 0, count = 0;

        while (right < nums.length) {
            k -= nums[right] == 1 ? 1 : 0;


            while (k < 0) {
                k += nums[left] == 1 ? 1 : 0;
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(sol.numSubarraysWithSum(nums, goal)); // Output: 4

        int[] nums1 = {0,0,0,0,0};
        int goal1 = 0;
        System.out.println(sol.numSubarraysWithSum(nums1, goal1)); // Output: 15
    }
}
