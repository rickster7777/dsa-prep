
public class Memoization {
    public static boolean subsetSumMemo(int[] arr, int index, int currentSum, int K, Boolean[][] dp) {
        // Base cases
        if (currentSum == K)
            return true;
        if (index == arr.length || currentSum > K)
            return false;

        // Check memo
        if (dp[index][currentSum] != null) {
            return dp[index][currentSum];
        }

        // Include current element
        boolean include = subsetSumMemo(arr, index + 1, currentSum + arr[index], K, dp);

        // Exclude current element
        boolean exclude = subsetSumMemo(arr, index + 1, currentSum, K, dp);

        // Store result
        return dp[index][currentSum] = include || exclude;
    }
}
