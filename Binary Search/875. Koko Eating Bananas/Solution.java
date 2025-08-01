class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMaxPile(piles);

        //STEP 2: looping through the piles using BS to get the most
        // optimized value.
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

    //STEP 1: To get the max value from a pile.
    private static int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    private static boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
            /*
             * Using (pile + k - 1) / k instead of pile / k ensures ceiling division
             * (rounding up), which is needed here.
             *
             * pile / k in Java does integer division and always rounds down.
             * For example, 7 / 4 = 1 (but you actually need 2 hours to eat 7 bananas at
             * speed 4).
             *
             * (pile + k - 1) / k is a trick to simulate ceil(pile / k) using integer math.
             * For example, (7 + 4 - 1) / 4 = 10 / 4 = 2 (correct).
             *
             * Why is this needed?
             * Koko can't eat partial bananas or split hours. If a pile isn't finished in an
             * exact number of hours, she needs a full extra hour for the leftovers.
             * So, we must always round up the division, which is what (pile + k - 1)
             */
        }
        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        Solution.minEatingSpeed(piles, h);
    }
}
/*
 * In Java, Math.ceil(pile / k) does not work as expected because pile / k is
 * integer division, which truncates (rounds down) before Math.ceil is applied.
 * For example, Math.ceil(7 / 4) is Math.ceil(1) which is 1, but you actually
 * want 2.
 * 
 * To get the correct ceiling division, you must first convert to double or use
 * the integer trick:
 * 
 * Correct with double:
 * Math.ceil((double)pile / k) → this gives the correct result, but returns a
 * double, so you need to cast to int.
 * 
 * Efficient integer trick:
 * (pile + k - 1) / k
 * This always rounds up and works with integers, so it's preferred for
 * performance and simplicity.
 */
/*
 * ✅ The Correct Simulation for piles = [3,6,7,11] and k = 4:
 * We calculate hours per pile like this:
 * 
 * Pile 0: 3 / 4 → 1 hour
 * Pile 1: 6 / 4 → 2 hours (6 bananas → 4 in first hour, 2 in second)
 * Pile 2: 7 / 4 → 2 hours
 * Pile 3: 11 / 4 → 3 hours
 * 
 * We use ceiling division:
 * 
 * hours = (pile + k - 1) / k
 * So:
 * Total hours = 1 + 2 + 2 + 3 = 8
 * ✅ Therefore, k = 4 works for h = 8.
 * 
 * 📌 Summary:
 * Each pile takes ceil(pile / k) hours.
 * Koko eats from only one pile per hour, never splitting time between multiple
 * piles.
 * So we don't track remaining bananas manually, we just calculate time needed
 * for each pile.
 * 
 */