
/*
Example 1:
Input: nums = [1, 2, 1, 3, 5, 2]
Output: [3, 5]
Explanation: The integers 3 and 5 have appeared only once.
NOTE: the correct answer is [3, 5], not [5, 3].

Example 2:
Input: nums = [-1, 0]
Output: [-1, 0]

Explanation: The integers -1 and 0 have appeared only once.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
     * Function to get the single
     * number in the given array
     */
    public List<Integer> singleNumber(int[] nums) {

        // Array to store the answer
        List<Integer> ans = new ArrayList<>();

        /*
         * Map to store the elements
         * and their frequencies
         */
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterate on the array
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1); // Update the map
        }

        // Iterate on the map
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            // If frequency is 1
            if (entry.getValue() == 1) {
                /*
                 * Add the element to
                 * the result array
                 */
                ans.add(entry.getKey());
            }
        }

        // Return the result after sorting
        Collections.sort(ans);
        return ans;
    }

    /*
     * Time Complexity: O(N), where N is the size of the array.
     * Traversing the array to update the Hash Map: O(N).
     * Traversing the map: O(N) (in the worst case).
     * Sorting the answer array: O(2*log(2)) ~ O(1).
     * 
     * Hence, the overall time complexity is O(N) + O(N) + O(1) ~ O(N).
     * 
     * Space Complexity: O(N), since we are using a hashmap data structure, and in
     * the
     * worst case (when all elements in the array are unique), it will store N
     * key-value pairs.
     */

    // Optimized Approach

    /*
     * Traverse the entire array, performing an XOR operation on all numbers. This
     * will effectively cancel out all the numbers that appear twice, leaving us
     * with the XOR of the two unique numbers.
     * Determine the rightmost set bit (bit that is 1) in the result from the first
     * step. This set bit can be used to differentiate the two unique numbers since
     * they must differ at this bit position.
     *
     *
     *
     *
     * Traverse the array again, but this time divide the numbers into two groups:
     * One group where the numbers have the rightmost set bit.
     * Another group where the numbers do not have this bit set.
     * Perform XOR operations while adding numbers in each group. This will cancel
     * out the duplicate numbers, leaving only the unique numbers in each group.
     * Sort the two unique numbers in ascending order and return them.
     */

    public int[] singleNumberOp(int[] nums) {
        // Variable to store size of array
        int n = nums.length;

        // Variable to store XOR of all elements
        long XOR = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Update the XOR
            XOR = XOR ^ nums[i];
        }


        // Till here it's same as single element.
        /*
         * Variable to get the rightmost set bit in overall XOR
         */
        int rightmost = (int) (XOR & (XOR - 1)) ^ (int) XOR;

        /*
         * Variables to stores XOR of elements in bucket 1 and 2
         */
        int XOR1 = 0, XOR2 = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            /*
             * Divide the numbers among bucket 1 and 2 based on rightmost set bit
             */
            if ((nums[i] & rightmost) != 0) {
                XOR1 = XOR1 ^ nums[i];
            } else {
                XOR2 = XOR2 ^ nums[i];
            }
        }

        // Return the result in sorted order
        if (XOR1 < XOR2)
            return new int[] { XOR1, XOR2 };
        return new int[] { XOR2, XOR1 };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 2 };

        /*
         * Creating an instance of
         * Solution class
         */
        Solution sol = new Solution();

        /*
         * Function call to get the single
         * number in the given array
         */
        List<Integer> ans = sol.singleNumber(nums);

        System.out.println("The single numbers in given array are: " + ans.get(0) + " and " + ans.get(1));
    }
}
