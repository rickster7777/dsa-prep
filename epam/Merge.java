import java.util.Arrays;

public class Merge {

    public static int[] mergeArrays(int[] nums, int[] num1, int[] num2) {
        //Step 1: lengths of the arrays
        int n = nums.length;
        int m = num1.length;
        int p = num2.length;

        //Step 2: Indexes for each array and result array
        int i = 0, j = 0, k = 0, l = 0;

        int[] result = new int[n + m + p];

        while (i < n || j < m || k < p) {

            // Step 3: Get current values or MAX_VALUE if index exceeds array length.
            int val1 = (i < n) ? nums[i] : Integer.MAX_VALUE;
            int val2 = (j < m) ? num1[j] : Integer.MAX_VALUE;
            int val3 = (k < p) ? num2[k] : Integer.MAX_VALUE;

            // Step 4: Compare values and add the smallest to result, then move the corresponding index.
            if (val1 <= val2 && val1 <= val3) {
                result[l++] = val1;
                i++;
            } else if (val2 <= val1 && val2 <= val3) {
                result[l++] = val2;
                j++;
            } else {
                result[l++] = val3;
                k++;
            }
        }
        System.out.println("Merged 3 arrays: " + Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {

        int[] nums = { 4, 5, 6 };
        int[] num1 = { 1, 2, 3 };
        int[] num2 = { 7, 8, 9 };

        // System.out.println("3 arrays merged: " + Arrays.toString(mergeArrays(nums, num1, num2)));



        int[] a1 = { 1, 4, 7 };
        int[] a2 = { 2, 5, 8 };
        int[] a3 = { 3, 6, 9 };
        int[] a4 = { 0, 10, 11 };
        int[] merged4 = mergeSortedArrays(new int[][] { a1, a2, a3, a4 });
        System.out.println("Merged 4 arrays: " + Arrays.toString(merged4));

        int[] b1 = { 1, 5 };
        int[] b2 = { 2, 6 };
        int[] b3 = { 3, 7 };
        int[] b4 = { 4, 8 };
        int[] b5 = { 0, 9, 10 };
        int[] merged5 = mergeSortedArrays(new int[][] { b1, b2, b3, b4, b5 });
        System.out.println("Merged 5 arrays: " + Arrays.toString(merged5));
    }

    private static int[] mergeSortedArrays(int[][] arrays) {

        //Step 1: Calculate total length of the result array
        int totalLength = 0;
        for (int[] array : arrays) {
            totalLength += array.length;
        }

        //Step 2: Create result array and pointers for each input array
        int[] result = new int[totalLength];
        int[] pointers = new int[arrays.length];

        // Step 3: Merge arrays using pointers to track current index in each array and find the minimum
        // value among the current elements of the arrays.
        for (int index = 0; index < totalLength; index++) {
            // Find the minimum value among the current elements of the arrays pointed by pointers
            int minValue = Integer.MAX_VALUE;

            // Also track which array has the minimum value to move its pointer later
            int minArray = -1;

            // Iterate through each array to find the minimum value
            for (int t = 0; t < arrays.length; t++) {
                // Check if the pointer for this array is still within bounds
                if (pointers[t] < arrays[t].length) {
                    // Get the current value from this array
                    int value = arrays[t][pointers[t]];
                    // Update minimum value and corresponding array index if this value is smaller
                    if (value < minValue) {
                        minValue = value;
                        minArray = t;
                    }
                }
            }

            // If minArray is -1, it means all pointers have exceeded their array lengths, which shouldn't happen
            if (minArray < 0) {
                break;
            }

            // Add the minimum value to the result and move the pointer of the array that had the minimum value
            result[index] = minValue;

            // Move the pointer for the array that had the minimum value
            pointers[minArray]++;
        }

        return result;
    }
}
