//349 Intersection of 2 arrays
package intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

