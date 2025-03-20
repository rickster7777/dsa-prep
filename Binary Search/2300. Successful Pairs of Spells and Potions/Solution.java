import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Step 1: Sort potions array
        int n = spells.length, m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int index = binarySearch(potions, spell, success);
            result[i] = m - index; // Count of valid potions
        }

        return result;
    }

    private int binarySearch(int[] potions, int spell, long success) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) spell * potions[mid] >= success) {
                right = mid; // Move left to find the first valid potion
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
