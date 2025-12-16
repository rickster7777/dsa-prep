/*
Algorithm:
Count the number of points where arr[i] > arr[i+1] (i.e., where the order breaks).
If there’s exactly one such point (or none), check the condition arr[n-1] <= arr[0] (for a proper rotation).
If the above conditions are satisfied, return True, otherwise return False.


in other words
To validate if an array is a rotated sorted array

Correct and Simple Approach
Key Idea:
1. Count number of “drops” in the array (where nums[i] < nums[i-1])
2. If there is more than one drop, it’s not rotated sorted
3. Also, check wrap-around between last and first element

*/

public class SortedAndRotated {

    // Function to check if the array is sorted and rotated
    public static boolean isSortedAndRotated(int[] arr) {
        int n = arr.length;

        // If the array has 1 or fewer elements, it's trivially sorted and rotated
        if (n <= 1) {
            return true;
        }

        int count = 0;

        // Count the number of places where the order breaks (arr[i] > arr[i+1])
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                count++;
            }
        }

        // Check the circular condition: last element must be <= first element
        if (arr[n - 1] > arr[0]) {
            count++;
        }

        // The array can have at most one rotation point
        return count <= 1;
    }

    // Test the function
    public static void main(String[] args) {
        // Test cases
        System.out.println(isSortedAndRotated(new int[]{3, 4, 5, 1, 2})); // True (rotated sorted array)
        System.out.println(isSortedAndRotated(new int[]{1, 2, 3, 4}));    // True (sorted, no rotation)
        System.out.println(isSortedAndRotated(new int[]{2, 3, 4, 5, 1})); // True (rotated sorted array)
        System.out.println(isSortedAndRotated(new int[]{2, 3, 1, 4}));    // False (not sorted or rotated properly)
    }
}
