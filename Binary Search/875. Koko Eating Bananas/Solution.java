class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMaxPile(piles);

        while (low < high) {
            int mid = low + (high - low) / 2; // Prevent integer overflow
            if (canFinish(piles, mid, h)) {
                high = mid; // Try lower speed
            } else {
                low = mid + 1; // Increase speed
            }
        }

        return low; // Minimum k found
    }

    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
        }
        return hoursNeeded <= h;
    }
}
