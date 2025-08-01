import java.util.Arrays;

/*
I was trying to achieve this in place 
which lead to complexity and wasn't able to come up with any solution.
 */

public class Solution {
    // Two-pointer approach to fill the result array from the end
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;            // Pointer to the start of the array
        int right = n - 1;       // Pointer to the end of the array
        int pos = n - 1;         // Position to fill in result array from the back

        // Compare squares from both ends and fill the result array from the end
        // This approach can be used because  the given array is already sorted.
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[pos] = leftSq; // Place the larger square at the current position
                left++;               // Move left pointer forward
            } else {
                result[pos] = rightSq; // Place the larger square at the current position
                right--;              // Move right pointer backward
            }

            pos--; // Move to the next position in result array
        }

        return result;
    }
}


// Using streams for a concise solution
class Solutio {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        // Square each element, sort the array, and return
        int[] arr = Arrays.stream(nums).map(x -> x*x).sorted().toArray();   

        return arr;
    }
}