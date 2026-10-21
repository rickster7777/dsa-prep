/*
Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
Example 2:

Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.

*/

public class Solution {
    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int max = arr[n - 1];
        arr[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] > max) { // if the current element is greater than the max,
            // we need to update the max and replace the current element with the previous max
                int temp = max;
                max = arr[i];
                arr[i] = temp;
            } else {
                arr[i] = max;
            }

        }

        return arr;
    }

    // slightly cleaner approach

    public int[] replaceElementsClean(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            // Save the current element before replacing it
            int current = arr[i];

            // Replace current element with greatest element on its right
            arr[i] = max;

            // Current element may become the new greatest
            max = Math.max(max, current);
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {17, 18, 5, 4, 6, 1};
        int[] result1 = solution.replaceElements(arr1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [18, 6, 6, 6, 1, -1]

        int[] arr2 = {400};
        int[] result2 = solution.replaceElements(arr2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [-1]
    }
}
