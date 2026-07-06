public class Optimization {
     public static boolean subsetSumDP(int[] arr, int K) {
        boolean[] dp = new boolean[K + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = K; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[K];
    }
}
