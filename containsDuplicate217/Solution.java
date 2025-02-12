package containsDuplicate217;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to track the elements we've seen
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the element is already in the HashSet, we found a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add the element to the set
            seen.add(num);
        }

        // If we completed the loop without finding a duplicate, return false
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(solution.containsDuplicate(nums));
    }

}
