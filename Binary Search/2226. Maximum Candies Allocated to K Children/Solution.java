class Solution {
    public static int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;

        for (int c : candies) {
            right = Math.max(right, c);
        }

        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(candies, k, mid)) {
                result = mid; // this value works, try for a higher one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean canDistribute(int[] candies, long k, int amount) {
        long count = 0;

        for (int pile : candies) {
            count += pile / amount;
        }

        return count >= k;
    }

    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        int k = 3;
        Solution.maximumCandies(candies, k);
    }
}
