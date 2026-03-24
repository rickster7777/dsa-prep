/*
Input:
nums = [1, -1, 5, -2, 3]
k = 3

Output:
4

Explanation:
[1, -1, 5, -2] sums to 3
*/

import java.util.HashMap;
import java.util.Map;

public class JPMC {

    // correct sol
    public static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        map.put(0, -1); // important for subarrays starting at index 0

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    /*
     * What if the interviewer asks this variant:
     * 
     * Return the number of subarrays whose sum equals k instead of the longest
     * length.
     * 
     * Example:
     * 
     * nums = [1,1,1]
     * k = 2
     * 
     * Output:
     * 
     * 2
     */

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]) {

        int[] nums = { 1, -1, 5, -2, 3 };
        int k = 3;

        int sum = 0;
        int max = 0;

        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];

            if (sum == k) {
                max = Math.max(max, i - j + 1);
            } else if (sum > k) {
                sum -= nums[i];
                i++;
            }
            j++;
        }

        System.out.println(max);
    }

}


/*
Let's Move to Question 2 (Harder)

👨‍💼 Interviewer

Design a Rate Limiter.

Requirement:

Limit a user to 100 requests per minute.

Questions:

How would you implement this in a single server?

How would you implement it in a distributed system?

Explain your approach step by step.

(Think like a backend engineer with 5 YOE, not just coding.)

*/