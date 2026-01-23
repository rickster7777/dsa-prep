/*
Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
Result: 4
Explanation: Index 4 is the smallest index such that arr[4] > x.

*/
public class UpperBound {

    /*
     * Your implementation works for many cases, but it has unnecessary complexity
     * and a subtle correctness issue in how ans is used.
     *
     * Let’s break it down and then fix it.
     * ❌ Issue in Your Code
     * if (arr[mid] <= x) {
     * ans = mid;
     * l = mid + 1;
     * }
     *
     * For upper_bound, we want the first index where arr[i] > x
     * But here you’re storing the last index where arr[mid] <= x.
     * Then returning ans + 1 to compensate
     *
     */
    public static int upperBound(int[] arr, int x) {

        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int ans = n;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans + 1;

    }
    /*
     * ✅ Cleaner & Preferred Upper Bound (Half-Open Interval)
     * This mirrors your better lowerBound solution:
     * 
     */

    public static int upperBoundHalfOpen(int[] arr, int x) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }



    //Template 2
    public static int upperBoundTemp2(int arr[], int target) {
        int n = arr.length;

        int left = 0, right = n - 1;
        int ans = n; // default if no element > target

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) { // This condition is the only diff when compared with lower bound.
                ans = mid; // possible answer
                right = mid - 1; // look for smaller index
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 3 };
        int x1 = 2;
        System.out.println("Upper Bound Index: " + UpperBound.upperBound(arr1, x1)); // Output: 3

        int[] arr2 = { 3, 5, 8, 9, 15, 19 };
        int x2 = 9;
        System.out.println("Upper Bound Index: " + UpperBound.upperBound(arr2, x2)); // Output: 4
    }
}
