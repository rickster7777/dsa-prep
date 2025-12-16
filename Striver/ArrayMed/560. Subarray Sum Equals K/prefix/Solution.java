import java.util.HashMap;
import java.util.Map;


//This problem is similar to the Longest subarray with given sum K.
// only difference is here we have to count the number of subarrays with sum equal to k
// instead of finding the length of longest subarray with sum equal to k
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // Check if there is a prefix sum that we can subtract to get k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update the map with current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(sol.subarraySum(nums, k)); // Output: 2



    }
}