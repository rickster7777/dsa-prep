/**
 * MergeSort - A stable, divide-and-conquer sorting algorithm
 * 
 * Time Complexity:
 * - Best Case: O(n log n) - consistent performance
 * - Average Case: O(n log n) - all inputs perform equally
 * - Worst Case: O(n log n) - guaranteed, unlike QuickSort
 * 
 * Space Complexity: O(n) - requires temporary arrays for merging
 * 
 * Advantages:
 * - Stable sort (preserves order of equal elements)
 * - Guaranteed O(n log n) performance
 * - Predictable and reliable
 * - Great for linked lists and external sorting
 * 
 * Disadvantages:
 * - Requires O(n) extra space for temporary arrays
 * - Slightly slower than QuickSort on average
 * - Not in-place (more memory overhead)
 */
public class MergeSort {

    /**
     * Merges two sorted subarrays into one sorted array
     * 
     * This method combines two sorted halves of an array:
     * - Left subarray: arr[left...mid]
     * - Right subarray: arr[mid+1...right]
     * 
     * The merge process:
     * 1. Create temporary arrays L and R to hold the two halves
     * 2. Compare elements from both arrays and place smaller element in main array
     * 3. Copy remaining elements from whichever array still has elements
     * 4. Result: arr[left...right] is now sorted
     * 
     * @param arr   the main array containing both subarrays
     * @param left  starting index of the left subarray
     * @param mid   ending index of the left subarray
     * @param right ending index of the right subarray
     */
    static void merge(int[] arr, int left, int mid, int right) {
        // Calculate the size of the left subarray (from left to mid, inclusive)
        int n1 = mid - left + 1;
        // Calculate the size of the right subarray (from mid+1 to right, inclusive)
        int n2 = right - mid;

        // Create temporary array L to store elements of left subarray
        int[] L = new int[n1];
        // Create temporary array R to store elements of right subarray
        int[] R = new int[n2];

        // Copy data from arr to left temporary array L
        // Copy elements arr[left] to arr[mid]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        // Copy data from arr to right temporary array R
        // Copy elements arr[mid+1] to arr[right]
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Three pointers for merging:
        // i - pointer for left subarray L
        // j - pointer for right subarray R
        // k - pointer for main array arr (starting from left)
        int i = 0, j = 0, k = left;

        // Merge the two subarrays back into arr
        // Compare elements from L and R, place the smaller one in arr
        // This loop continues while both arrays have elements to compare
        while (i < n1 && j < n2) {
            // If current element in L is less than or equal to current element in R,
            // place L[i] into arr and move pointers i and k forward
            // Using <= ensures stable sort (maintains order of equal elements)
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                // Otherwise place R[j] into arr and move pointers j and k forward
                arr[k++] = R[j++];
            }
        }

        // Copy any remaining elements from left subarray L
        // This runs if R is exhausted but L still has elements
        while (i < n1)
            arr[k++] = L[i++];

        // Copy any remaining elements from right subarray R
        // This runs if L is exhausted but R still has elements
        while (j < n2)
            arr[k++] = R[j++];
    }

    /**
     * Recursively divides the array into smaller subarrays and merges them
     * 
     * Approach (Divide and Conquer):
     * 1. Divide: Split the array into two halves at the midpoint
     * 2. Conquer: Recursively sort each half
     * 3. Combine: Merge the two sorted halves together
     * 
     * The recursion continues until we reach arrays of size 1 (already sorted)
     * Then we merge back up the recursion tree, progressively merging larger sorted
     * subarrays
     * 
     * @param arr   the array to be sorted
     * @param left  the starting index of the subarray to sort
     * @param right the ending index of the subarray to sort
     */
    static void mergeSort(int[] arr, int left, int right) {
        // Base case: if left >= right, the subarray has 0 or 1 elements and is already
        // sorted
        if (left < right) {
            // Calculate the midpoint of the current subarray
            // This divides the array into two halves
            int mid = (left + right) / 2;

            // Recursively sort the left half (from left to mid)
            // This continues until the left subarray is of size 1
            mergeSort(arr, left, mid);

            // Recursively sort the right half (from mid+1 to right)
            // This continues until the right subarray is of size 1
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            // At this point, both halves are sorted, so we just need to combine them
            merge(arr, left, mid, right);
        }
    }

    /**
     * Main method to test the MergeSort algorithm
     * Creates a sample unsorted array, sorts it using MergeSort, and prints the
     * result
     */
    public static void main(String[] args) {
        // Sample unsorted array
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

        // Call mergeSort starting from index 0 to arr.length-1 to sort entire array
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 3 9 10 27 38 43 82
    }
}
