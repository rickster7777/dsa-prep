//349 Intersection of 2 arrays
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]


Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Intersection means elements which are common in both the arrays.
*/
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();

        // Add elements of nums1 to numSet1
        for (int num : nums1) {
            numSet1.add(num);
        }

        // Check for intersection with nums2
        for (int num : nums2) {
            if (numSet1.contains(num)) {
                numSet2.add(num);
            }
        }

        // Convert the set to an array
        return numSet2.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2]
    }
}


//-----------------------------------------------------------------------------------------------------
// using Streams

