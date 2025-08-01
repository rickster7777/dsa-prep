/*
 * 605. Can Place Flowers
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent 
plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if 
n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // Count of flowers we can plant
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;

                    if (count >= n)
                        return true; // If we plant all required flowers
                }
            }
        }
        return count >= n;
    }

}

/*
✅ What They Mean
🔸 emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
This checks if the plot to the left of position i is empty.

Two cases:
    If i == 0, it’s the first plot, so there’s no left neighbor — it's considered empty.
    Otherwise, it checks whether flowerbed[i - 1] is 0 (i.e., no flower planted there).

🔸 emptyRight = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
This checks if the plot to the right of position i is empty.

Two cases:
    If i is the last index, there’s no right neighbor — it's considered empty.
    Otherwise, it checks whether flowerbed[i + 1] is 0.

✅ Why This Matters
To safely plant a flower at index i, three conditions must be true:

flowerbed[i] == 0 → the current spot is empty
flowerbed[i - 1] == 0 or it’s the start of the array
flowerbed[i + 1] == 0 or it’s the end of the array
 */