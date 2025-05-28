import java.util.HashMap;
import java.util.Map;


/*
 🔍 Logic Summary:
Convert the problem to finding the longest subarray with sum 0.

Replace 0s with -1 to make equal number of 0s and 1s equivalent to a net sum of 0.

Use prefix sum + hashmap to detect repeated sums and calculate lengths between them.
 */


public class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence index of each cumulative sum
        // Key: cumulative sum, 
        //Value: first index where this sum occurred
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize map with sum 0 at index -1 to handle subarrays starting at index 0
        map.put(0, -1);

        int maxLen = 0; // To keep track of the maximum length found
        int sum = 0; // Cumulative sum, where 0s are treated as -1 and 1s as +1

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1 and 1 as +1 to convert problem into finding subarray with sum = 0
            sum += (nums[i] == 0) ? -1 : 1;

            // If this cumulative sum has been seen before
            if (map.containsKey(sum)) {
                // Calculate the length of the subarray from the first occurrence to current index
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return maxLen; // Return the maximum length of the balanced subarray
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1 }; // Example 3 from the problem
        Solution obj = new Solution();
        int result = obj.findMaxLength(nums);
        System.out.println("Maximum length of contiguous subarray: " + result);
    }
}

/*
 * 🧠 Algorithm (Prefix Sum + HashMap)
 * Initialize:
 * 
 * map = {0: -1} → maps cumulative sum to its earliest index
 * max_len = 0
 * sum = 0
 * 
 * Iterate through array:
 * For each element:
 * 
 * If num == 0, treat as -1, else +1
 * Add to sum
 * 
 * If this sum has been seen before in the map:
 * Calculate length = i - map[sum]
 * Update max_len if needed
 * 
 * If not seen:
 * Store the index of first occurrence: map[sum] = i
 * 
 * 🧮 Example:
 * Input: [0,1,1,1,1,1,0,0,0]
 * Convert to: [-1,+1,+1,+1,+1,+1,-1,-1,-1]
 * 
 * Now you're looking for longest subarray with sum = 0
 */