class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Your current solution is O(n²), which will time out for n ≤ 5 * 10^4.
    // This problem requires a modified merge sort (O(n log n)) approach**, similar
    // to counting inversions.

    /*
     * ✅ Optimal Approach: Merge Sort + Two Pointers
     * Key Idea
     * 
     * While merging two sorted halves:
     * 
     * For each element in the left half,
     * Count how many elements in the right half satisfy:
     * nums[i] > 2 * nums[j]
     * 
     * 
     * Because both halves are sorted, we can use a moving pointer.
     * 
     * 🔥 Important Edge Case
     * 
     * Since nums[i] can be up to 2^31 - 1,
     * 2 * nums[j] can overflow.
     * 
     * 👉 Always cast to long:
     * (long) nums[i] > 2L * nums[j]
     */

    public int reversePairsMerge(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

        return count;
    }

    private int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}