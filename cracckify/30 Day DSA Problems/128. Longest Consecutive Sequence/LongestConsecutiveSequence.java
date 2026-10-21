/*
Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3

You must write an algorithm that runs in O(n) time.

*/

/*
can't think of a solution without sorting

maybe treemap will be used in this case


✅ Step-by-Step Algorithm
1️⃣ Add all elements to a HashSet
2️⃣ For each number:
If num - 1 does not exist → start counting
    3️⃣ Expand forward while num + 1 exists
    4️⃣ Track maximum length




🔁 Pattern Recognition

This problem uses:
HashSet
Sequence start detection
Avoid repeated work

Appears again in:
Longest increasing sequence variants
Range-based problems
Interval merging concepts
*/
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // LeetCode solution method
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // STEP 1: Add all elements to a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        // STEP 2: Iterate through the set to find the longest consecutive sequence
        for (int num : set) {
            // Start only if this is the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // STEP 3: Expand the sequence forward
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // STEP 4: Update the longest sequence found
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {1, 0, 1, 2};

        System.out.println(longestConsecutive(nums1)); // Expected: 4
        System.out.println(longestConsecutive(nums2)); // Expected: 9
        System.out.println(longestConsecutive(nums3)); // Expected: 3
    }
}
