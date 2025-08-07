// var shortestSubarray = function (nums, k) {
//     let n = nums.length;
//     let minLen = Infinity;
//     let currentOr = 0;
//     let counter = 0;

//     for (let i = 0; i < n; i++) {
//         currentOr += nums[i];

//         if (currentOr >= k) {
//             minLen = Math.min(minLen, (i - counter) + 1);
//             currentOr -= nums[counter];
//             counter++;
//         }

//     }

//     return minLen === Infinity ? -1 : minLen;
// };
import java.util.*;

public class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = n + 1;

        for (int i = 0; i < prefix.length; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLen <= n ? minLen : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // int[] nums1 = { 1 };
        // int[] nums2 = { 1, 2 };
        int[] nums3 = { 2, -1, 2 };

        // System.out.println(sol.shortestSubarray(nums1, 1)); // Output: 1
        // System.out.println(sol.shortestSubarray(nums2, 4)); // Output: -1
        System.out.println(sol.shortestSubarray(nums3, 3)); // Output: 3
    }
}

// const nums = [2, -1, 2], k = 3;
// console.log(shortestSubarray(nums, k));