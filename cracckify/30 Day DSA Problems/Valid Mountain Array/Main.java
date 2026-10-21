/*
Valid Mountain Array
Success rate: 65.71%
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
<img width="500" src="https://assets.leetcode.com/uploads/2019/10/20/hint_valid_mountain_array.png" />
 

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true

 

Constraints:

1 <= arr.length <= 10<sup>4</sup>
0 <= arr[i] <= 10<sup>4</sup>
*/
public class Main {
    public static boolean ValidMountainArray(int[] arr) {
        // Your Code Here
        if (arr.length < 3) {
            return false;
        }

        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
