import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Why Long instead of Integer?

        // To avoid integer overflow when handling large values (since nums[i] + valueDiff can be large).

        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Finds the largest number in the TreeSet that is ≤ (nums[i] + valueDiff).
            Long floor = window.floor((long) nums[i] + valueDiff);

            //Finds the smallest number in the TreeSet that is ≥ (nums[i] - valueDiff).
            Long ceiling = window.ceiling((long) nums[i] - valueDiff);

            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }

            window.add((long) nums[i]);

            if (window.size() > indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0)); // true
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 3, 2)); // false
    }
}
