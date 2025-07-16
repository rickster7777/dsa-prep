import java.util.*;

public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long[] count = new long[101];

        // Count occurrences of each number
        for (int num : arr) {
            count[num]++;
        }

        long result = 0;

        // Iterate x, y and calculate z = target - x - y
        for (int x = 0; x <= 100; x++) {
            if (count[x] == 0) continue;
            for (int y = x; y <= 100; y++) {
                if (count[y] == 0) continue;
                int z = target - x - y;
                if (z < 0 || z > 100 || count[z] == 0) continue;
                if (x == y && y == z) {
                    // Case 1: x == y == z
                    result += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                } else if (x == y && y != z) {
                    // Case 2: x == y != z
                    result += count[x] * (count[x] - 1) / 2 * count[z];
                } else if (x < y && y < z) {
                    // Case 3: all different
                    result += count[x] * count[y] * count[z];
                } else if (x != y && y == z) {
                    // Case 4: x != y == z
                    result += count[x] * count[y] * (count[y] - 1) / 2;
                }
                result %= MOD;
            }
        }

        return (int) result;
    }
}


/*
 1. Count frequency of each number
2. Loop through all possible value combinations (x, y, z)
3. For each valid (x, y, z), count how many index-triplets can be made

Depending on whether values are the same or different, use combinatorics:

✅ Case 1: All values different (x ≠ y ≠ z)
Total ways = freq[x] * freq[y] * freq[z]

✅ Case 2: x == y ≠ z
Total ways = C(freq[x], 2) * freq[z]
(Choose 2 x's, 1 z)

✅ Case 3: x ≠ y == z
Total ways = freq[x] * C(freq[y], 2)

✅ Case 4: x == y == z
Total ways = C(freq[x], 3)
(Choose 3 of same number)

Where C(n, k) is the number of ways to choose k items from n:
C(n, 2) = n * (n - 1) // 2
C(n, 3) = n * (n - 1) * (n - 2) // 6


🧮 Example Breakdown
Input:
arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Look for all triplets (x, y, z) such that x + y + z == 8:
(1,2,5) → 2 ones × 2 twos × 2 fives = 8
(1,3,4) → 2 × 2 × 2 = 8
(2,2,4) → C(2,2) × 2 = 1 × 2 = 2
(2,3,3) → 2 × C(2,2) = 2 × 1 = 2
Total = 8 + 8 + 2 + 2 = 20

⌛ Time & Space Complexity
Time: O(100³) at worst — because numbers in arr range from 0 to 100
Space: O(1) effectively — constant space for frequency map
 */

 
/*
Given an integer array arr, and an integer target, return the number of tuples i, j, k
such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

Constraints:

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
 */