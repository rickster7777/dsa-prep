import java.util.*;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Start from the largest number down to 1
        for (int valueToPlace = arr.length; valueToPlace > 1; valueToPlace--) {
            // Find the index of the current largest unsorted value
            int index = findIndex(arr, valueToPlace);

            // If it's already in the correct position, skip
            if (index == valueToPlace - 1) continue;

            // Step 1: Bring it to the front if it's not already there
            if (index != 0) {
                flip(arr, index + 1);  // Flip first index+1 elements
                result.add(index + 1);
            }

            // Step 2: Move it to its correct position
            flip(arr, valueToPlace);  // Flip first valueToPlace elements
            result.add(valueToPlace);
        }

        return result;
    }

    // Helper to flip the first k elements
    private void flip(int[] arr, int k) {
        int left = 0, right = k - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Helper to find the index of a value in the array
    private int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;  // Should never happen
    }
}
