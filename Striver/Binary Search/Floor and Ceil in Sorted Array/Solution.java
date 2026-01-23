
/*
Example 1:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
Result: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
Result: 8 8
Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

*/
import java.util.*;

public class Solution {

    public static int[] floorAndCeil(int[] arr, int x) {

        int n = arr.length;
        int l = 0, r = n - 1;
        int ansL = arr[n - 1], ansS = arr[0];

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] > x) {
                ansL = arr[mid];
                r = mid - 1;
            } else if (arr[mid] < x) {
                ansS = arr[mid];
                l = mid + 1;
            }

        }
        return new int[] { ansS, ansL };

    }
    /*
     * Is it correct And why the output for the second input is not getting printed
     * 👉 What if arr[mid] == x?
     * 
     * Neither if nor else if runs
     * l and r are NOT updated
     * mid stays the same
     * 
     * while (l <= r) becomes an infinite loop
     * This happens in Example 2 (x = 8), because arr[mid] == 8 at some point.
     * That’s why the program never reaches the second println.
     * 
     * 
     * ❌ Another logical issue (even for Example 1)
     * 
     * You initialized:
     * int ansL = arr[n - 1]; // ceil
     * int ansS = arr[0]; // floor
     * 
     * This gives wrong answers if:
     * floor does not exist
     * ceil does not exist
     * 
     * Example:
     * x = 1 → floor should be -1
     * x = 20 → ceil should be -1
     * 
     */

    public static int[] floorAndCeilCorrected(int[] arr, int x) {

        int n = arr.length;
        int l = 0, r = n - 1;
        int floor = -1, ceil = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                floor = x;
                ceil = x;
                break;
            } else if (arr[mid] < x) {
                floor = arr[mid];
                l = mid + 1;
            } else {
                ceil = arr[mid];
                r = mid - 1;
            }
        }

        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int x = 5;

        System.out.println(Arrays.toString(Solution.floorAndCeil(arr, x)));

        int[] arr1 = { 3, 4, 4, 7, 8, 10 };
        int n1 = 8;

        System.out.println(Arrays.toString(Solution.floorAndCeil(arr1, n1)));

    }
}
