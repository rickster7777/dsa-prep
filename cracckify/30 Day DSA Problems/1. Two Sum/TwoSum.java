import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // To store value and its index+

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the complement

            // If the complement is already in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number with its index
            map.put(nums[i], i);
        }

        return new int[] {}; // Return an empty array if no solution (shouldn't happen per problem
                             // constraints)
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target))); // Output: [0, 1]
    }
}
