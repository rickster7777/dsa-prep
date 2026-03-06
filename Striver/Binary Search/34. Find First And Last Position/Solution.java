class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[] { first, last };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                // Keep searching to the left (for first) or right (for last)
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = solution.searchRange(nums, target);

        System.out.println("First and Last Position of Target " + target + ": [" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]
    }
}
