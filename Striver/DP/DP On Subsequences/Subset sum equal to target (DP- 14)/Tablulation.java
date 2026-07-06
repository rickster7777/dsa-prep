/*
👉 Time: O(N × K)
👉 Much faster for bigger inputs

*/
public class Tablulation {
   public static boolean subsetSumTab(int[] arr, int K) {
    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][K + 1];

    // Base case: sum = 0 is always possible
    for (int i = 0; i <= n; i++) {
        dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= K; j++) {
            if (arr[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][K];
}

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int K = 5;

        boolean result = subsetSumTab(arr, K);
        System.out.println("Is there a subset that sums to " + K + "? " + result);

        int[] arr1 = { 4, 3, 5, 2 };
        int K1 = 6;

        boolean result1 = subsetSumTab(arr1, K1);
        System.out.println("Is there a subset that sums to " + K1 + "? " + result1);

        int[] arr2 = { 1, 2, 5 };
        int K2 = 4;

        boolean result2 = subsetSumTab(arr2, K2);
        System.out.println("Is there a subset that sums to " + K2 + "? " + result2);
    }
}
