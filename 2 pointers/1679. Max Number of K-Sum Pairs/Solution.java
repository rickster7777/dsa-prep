import java.util.HashMap;
import java.util.Map;


public class Solution {
    /**
     * Finds the maximum number of pairs in the array that sum up to k.
     * Each element can be used at most once in a pair.
     *
     * @param nums the input array
     * @param k the target sum for each pair
     * @return the maximum number of k-sum pairs
     */
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // Stores the count of each number
        int count = 0; // Number of valid pairs found

        for (int num : nums) {
            // num + target = k; =>  target = k - num;
            int target = k - num; // The number needed to form a pair with 'num' to sum to k

            // If the target exists in the map and hasn't been used up
            if (map.containsKey(target) && map.get(target) > 0) {
                count++; // Found a valid pair
                map.put(target, map.get(target) - 1); // Use up one occurrence of the target
            } else {
                // Otherwise, store the current number for future pairs
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; int k = 5;
        System.out.println(Solution.maxOperations(nums, k));
    }
}
