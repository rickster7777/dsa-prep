/*
✅ 1. If the array is SORTED → Binary Search (Best)

Most efficient in practice
Time Complexity
O(log n)

✅ 2. If the array is UNSORTED → HashSet (Fastest lookup)

Most efficient overall when multiple searches are needed
Time Complexity O(n) to build
O(1) average lookup

⚠️ 3. Linear Search (Worst but simplest)
Only good for very small arrays
Time Complexity O(n)


| Scenario                     | Best Method   | Time         |
| ---------------------------- | ------------- | ------------ |
| Sorted array                 | Binary Search | **O(log n)** |
| Unsorted, many searches      | HashSet       | **O(1)**     |
| One-time search, small array | Linear Search | O(n)         |


*/


import java.util.HashSet;

public class Solution {

    // Binary Search - for sorted arrays
    public static boolean existsBinary(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // HashSet - for unsorted arrays with multiple lookups
    public static boolean existsHashSet(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        return set.contains(target);
    }

    // Linear Search - simple but slower
    public static boolean exists(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}