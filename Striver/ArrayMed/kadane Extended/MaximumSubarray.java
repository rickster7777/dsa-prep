/*
This is the extended version of Kadane’s Algorithm, where you not only find the maximum subarray sum, but also print the subarray that gives this maximum sum.

Problem Statement
Given an integer array, find:
The maximum subarray sum
The subarray (continuous) that produces this sum

Example

Input:
arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output:
Maximum Sum = 6
Subarray = [4, -1, 2, 1]

Key Idea (Extended Kadane)

Classic Kadane only tracks the sum.
Extended Kadane additionally tracks:

start index of current subarray
start & end indices of maximum sum subarray

Variables Used:
currentSum → sum of current subarray
maxSum → maximum sum found so far
start → temporary start index
ansStart, ansEnd → final subarray indices

Algorithm Steps

1. Initialize:
    currentSum = 0
    maxSum = Integer.MIN_VALUE

2. Traverse array:
    If currentSum == 0, mark new start
    Add current element to currentSum

3. If currentSum > maxSum:
    Update maxSum
    Store start & end indices

4. If currentSum < 0:
    Reset currentSum = 0

5.Print subarray from ansStart to ansEnd

*/


public class MaximumSubarray {

    public static void maxSubarrayWithPrint(int[] arr) {

        // Stores the maximum subarray sum found so far
        int maxSum = Integer.MIN_VALUE;

        // Stores the sum of the current subarray
        int currentSum = 0;

        // Temporary start index for the current subarray
        int start = 0;

        // Final start and end indices of the maximum subarray
        int ansStart = 0, ansEnd = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            /*
             * If currentSum is 0, it means:
             * - either we are at the beginning
             * - or the previous subarray was discarded
             * So we start a new subarray from index i
             */
            if (currentSum == 0) {
                start = i;
            }

            // Add the current element to current subarray sum
            currentSum += arr[i];

            /*
             * If the current subarray sum is better than maxSum,
             * update maxSum and store the start & end indices
             */
            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }

            /*
             * If currentSum becomes negative, it will reduce
             * future subarray sums, so discard it
             */
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Print maximum subarray sum
        System.out.println("Maximum Subarray Sum = " + maxSum);

        // Print the subarray
        System.out.print("Subarray = ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubarrayWithPrint(arr);
    }
}


/*
Can We Use Math.max() similar to the classic Kadane?
✅ Yes — but with limitations
❌ Problem with using only Math.max()

Classic Kadane uses:
currentSum = Math.max(arr[i], currentSum + arr[i]);
maxSum = Math.max(maxSum, currentSum);


But this does NOT track indices, so:
You know the max sum
❌ You don’t know which subarray produced it

*/