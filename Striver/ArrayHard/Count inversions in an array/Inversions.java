/*
Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

Inversion of an array: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Examples
Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 7
Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition.
*/
public class Inversions {

    /*
    Time Complexity: O(N2), as every pair is checked.
    Space Complexity: O(1), since no extra space is used apart from variables.
    */
    public static int inversion(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal Solution
    /*
    Time Complexity: O(N log N), since it is based on merge sort.
    Space Complexity: O(N), for the temporary array used during merging.

    An inversion in an array is defined as a pair of indices (i, j) such that i < j and a[i] > a[j]. This measures how far the array is from being sorted.
    To count inversions, the brute force way is to compare every element with all elements to its right and increment the counter whenever we find an inversion.

    Initialize a counter cnt = 0.
    Use two nested loops:
        Outer loop runs for each element a[i].
        Inner loop checks all elements a[j] where j > i.
        If a[i] > a[j], increment cnt.

    After traversing all pairs, return cnt as the number of inversions.
    */

    public static int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1); // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }
    public static int mergeSort(int[] nums, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(nums, left, mid);
            count += mergeSort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(inversion(nums));

        int[] nums1 = { 5, 4, 3, 2, 1 };
        System.out.println(inversion(nums1));

        int[] nums2 = { 5, 3, 2, 1, 4 };
        System.out.println(mergeSort(nums2, 0 , nums2.length - 1));
    }
}
