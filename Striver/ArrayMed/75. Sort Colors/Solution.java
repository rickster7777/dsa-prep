class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap current element with low pointer
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in correct region; just move mid
                mid++;
            } else { // nums[mid] == 2
                // Swap current element with high pointer
                swap(nums, mid, high);
                high--;
                // mid is NOT incremented here because swapped value may need re-checking
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
