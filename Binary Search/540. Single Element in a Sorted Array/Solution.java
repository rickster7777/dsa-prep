class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Make mid even to always compare with mid + 1
            /*
             * We want to compare each pair like this:
             * If mid is even → compare nums[mid] and nums[mid + 1]
             * If mid is odd → nums[mid] might be the second of a pair, and that’s confusing

             * To simplify the logic and always compare a pair (mid, mid + 1), we force mid
             * to be even:

             * 🔸 Why even mid is safer:
             * It ensures we're at the first index of a potential pair
             *
             * So we can safely check:
             * If nums[mid] == nums[mid + 1]: pair is valid → search right
             * Else: broken pair → single is on the left or at mid
             */
            if (mid % 2 == 1) {
                mid--; // force mid to be even
            }

            if (nums[mid] == nums[mid + 1]) {
                // Pair is correct → unique is on right
                low = mid + 2;
            } else {
                // Pair is broken → unique is on left (or at mid)
                high = mid;
            }
        }

        return nums[low]; // low == high at the end → unique element
    }

    public int mapSingleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
