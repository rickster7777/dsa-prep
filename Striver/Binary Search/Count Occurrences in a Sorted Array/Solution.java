/*
Example 1
Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1
Output: 3
Explanation: The number 1 appears 3 times in the array.

Example 2
Input: arr = [5, 5, 5, 5, 5, 5], target = 5
Output: 6
Explanation: All elements in the array are 5, so the target appears 6 times.
*/
public class Solution {
    public int countOccurrences(int[] arr, int target) {
        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        if (first == -1) return 0;
        return last - first + 1;
    }

    private int findBound(int[] arr, int target, boolean isFirst) {
        int left = 0, right = arr.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0, 0, 1, 1, 1, 2, 3};
        int target = 1;

        int count = solution.countOccurrences(arr, target);

        System.out.println("Count of occurrences of " + target + ": " + count); // Output: 3
    }
}
