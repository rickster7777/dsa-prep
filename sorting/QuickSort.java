/**
 * QuickSort - An efficient divide-and-conquer sorting algorithm
 *
 * Time Complexity:
 *   - Best Case: O(n log n) - when pivot divides array evenly
 *   - Average Case: O(n log n) - typical random input
 *   - Worst Case: O(n²) - when pivot is always smallest/largest element
 *
 * Space Complexity: O(log n) - due to recursion call stack
 *
 * Advantages:
 *   - Very fast on average
 *   - In-place sorting (minimal extra memory)
 *   - Cache-efficient
 *
 * Disadvantages:
 *   - Unstable sort (doesn't preserve order of equal elements)
 *   - Worst case is O(n²)
 */
public class QuickSort {

    /**
     * Partitions the array into two parts: elements less than pivot and greater than pivot
     *
     * Algorithm:
     * 1. Choose the last element as pivot
     * 2. Use two pointers (i and j) to partition the array
     * 3. Elements smaller than pivot move to the left side
     * 4. Elements greater than or equal to pivot stay on the right side
     * 5. Place pivot in its final sorted position

     * @param arr the array to partition
     * @param low starting index of the partition range
     * @param high ending index of the partition range
     * @return the index where the pivot element is placed in final position
     */
    static int partition(int[] arr, int low, int high) {
        // Choose the last element as the pivot element for partitioning
        int pivot = arr[high];

        // i points to the position where elements smaller than pivot will be placed
        // Initialized to low-1 because we'll increment it before placing smaller elements
        int i = low - 1;

        // Iterate through all elements from low to high-1
        // This loop finds all elements smaller than pivot and moves them to the left
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot, swap it with element at i+1
            if (arr[j] < pivot) {
                i++;  // Move the partition boundary one position right

                // Swap arr[i] and arr[j] to place smaller element on the left side
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot element in its final correct position
        // Swap pivot (currently at high) with element at i+1
        // This ensures all elements left of i+1 are smaller than pivot
        // and all elements right of i+1 are greater than pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the final position of the pivot
        return i + 1;
    }

    /**
     * Recursive function that sorts the array using QuickSort algorithm
     * 
     * Approach:
     * 1. If subarray has more than one element (low < high):
     *    a. Partition the array around a pivot element
     *    b. Recursively sort the left subarray (elements smaller than pivot)
     *    c. Recursively sort the right subarray (elements greater than pivot)
     * 2. Base case: Arrays with 0 or 1 element are already sorted
     * 
     * @param arr the array to be sorted
     * @param low the starting index of the subarray to sort
     * @param high the ending index of the subarray to sort
     */
    static void quickSort(int[] arr, int low, int high) {
        // Base case: if low >= high, the subarray has 0 or 1 elements and is already sorted
        if (low < high) {
            /**
             * Partition the array and get the pivot's final position
             * After partition:
             * - All elements before pi are < pivot
             * - All elements after pi are >= pivot
             */
            int pi = partition(arr, low, high);

            // Recursively sort the left subarray (all elements less than pivot)
            // Excludes pi because pivot is now in its final sorted position
            quickSort(arr, low, pi - 1);

            // Recursively sort the right subarray (all elements greater than pivot)
            // Excludes pi because pivot is already in correct position
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Main method to test the QuickSort algorithm
     * Creates a sample array, sorts it using QuickSort, and prints the sorted result
     */
    public static void main(String[] args) {
        // Sample unsorted array
        int[] arr = {10, 7, 8, 9, 1, 5};

        // Call quickSort starting from index 0 to arr.length-1 to sort entire array
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 5 7 8 9 10
    }
}
