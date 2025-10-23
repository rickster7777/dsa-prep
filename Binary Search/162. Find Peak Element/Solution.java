/*
🧠 Key Insight
Even though the array is not sorted, the peak must exist and we can find it using a modified binary search.

| Question                     | Answer                                                               |
| ---------------------------- | -------------------------------------------------------------------- |
| Is the array sorted?         | ❌ No                                                                 |
| Is binary search valid here? | ✅ Yes — we're searching for a **peak**                               |
| Why does this work?          | Because a **peak always exists** and the **slope** guides the search |

*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right
                start = mid + 1;
            } else {
                // Peak is on the left or at mid
                end = mid;
            }
        }

        // start == end → a peak element
        return start;
    }

    // Test it
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(sol.findPeakElement(nums1)); // Output: 2 (index of 3)
        System.out.println(sol.findPeakElement(nums2)); // Output: 5 (index of 6)
    }
}
