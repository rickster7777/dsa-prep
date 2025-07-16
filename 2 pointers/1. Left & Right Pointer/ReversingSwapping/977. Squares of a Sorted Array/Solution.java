
import java.util.Arrays;

/*
I was trying to achieve this in place 
which lead to complexity and wasn't able to come up with any solution.
 */

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        int pos = n - 1;  // position to fill in result array from back

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[pos] = leftSq;
                left++;
            } else {
                result[pos] = rightSq;
                right--;
            }

            pos--;
        }

        return result;
    }
}


// using streams
class Solutio {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n];
        
        arr = Arrays.stream(nums).map(x -> x*x).sorted().toArray();   

        return arr;
    }
}