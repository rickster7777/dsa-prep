/*
LC 3165 will this be of any help

Short answer: yes, it helps conceptually — but not as-is for efficiency or correctness of the actual problem.

Your function generates all subsequences, which is exactly what subset-sum is based on. But right now it:

only prints subsequences
does not check their sum
does not stop early when a valid subset is found
is exponential (2ⁿ) and inefficient for large inputs
🔧 How to adapt your approach

You’re very close. Instead of printing, you should:

1. Track the current sum
2. Return true immediately when sum == K
3. Stop exploring further once found

⚠️ Important notes
1. Early stopping is key

Your current code explores all subsequences, but we only need one valid subset.

2. Time complexity
Your approach (and above fix): O(2ⁿ)
Works fine for small N (≤ 20–25)
*/

public class Solution {
    public static boolean subsetSum(int[] arr, int index, int currentSum, int K) {
        // If sum matches
        if (currentSum == K)
            return true;

        // If end reached or sum exceeded
        if (index == arr.length || currentSum > K)
            return false;

        // Include current element
        if (subsetSum(arr, index + 1, currentSum + arr[index], K)) {
            return true;
        }

        // Exclude current element
        return subsetSum(arr, index + 1, currentSum, K);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int K = 5;

        boolean result = subsetSum(arr, 0, 0, K);
        System.out.println("Is there a subset that sums to " + K + "? " + result);

        int[] arr1 = { 4, 3, 5, 2 };
        int K1 = 6;

        boolean result1 = subsetSum(arr1, 0, 0, K1);
        System.out.println("Is there a subset that sums to " + K1 + "? " + result1);

        int[] arr2 = { 1, 2, 5 };
        int K2 = 4;

        boolean result2 = subsetSum(arr2, 0, 0, K2);
        System.out.println("Is there a subset that sums to " + K2 + "? " + result2);
    }
}
