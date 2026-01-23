/*

What is lower bound?
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.

Examples
Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 1
Explanation: Index 1 is the smallest index such that arr[1] >= x.

Example 2:
Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] >= x.

*/
public class LowerBound {

    // Both the functions are giving the same result
    // ChatGPT
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    //Template 2
    public static int lowerBoundTemp2(int arr[], int target) {

        int n = arr.length;

        int left = 0, right = n - 1;
        int ans = n; // default if no element >= target

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
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
        int target1 = 2;
        System.out.println("Lower Bound Index: " + LowerBound.lowerBound(arr1, target1)); // Output: 1
        System.out.println("Lower Bound Index temp 2:" + LowerBound.lowerBoundTemp2(arr1, target1)); // Output: 1

        int[] arr2 = { 3, 5, 8, 15, 19 };
        int target2 = 9;
        System.out.println("Lower Bound Index: " + LowerBound.lowerBound(arr2, target2)); // Output: 3
        System.out.println("Lower Bound Index temp 2:" + LowerBound.lowerBoundTemp2(arr2, target2));

        // int[] arr3 = { 1, 3, 5, 7, 9 };
        // int target3 = 6;
        // System.out.println("Lower Bound Index: " + lowerBound(arr3, target3)); // Output: 3

        // int[] arr4 = { 2, 4, 6, 8, 10 };
        // int target4 = 11;
        // System.out.println("Lower Bound Index: " + lowerBound(arr4, target4)); // Output: 5
    }
}
