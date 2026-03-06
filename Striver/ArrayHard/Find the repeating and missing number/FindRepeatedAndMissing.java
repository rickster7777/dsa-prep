import java.util.Arrays;

public class FindRepeatedAndMissing {

    /**
     * Finds the repeating and missing number in an array.
     * Array contains numbers from 1 to n, with one number missing and one repeated.
     * 
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(1) excluding output array.
     * 
     * @param nums The input array
     * @return int[2] where result[0] = repeating number, result[1] = missing number
     */
    public static int[] findRepeatingAndMissing(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);

        // Find repeating number and missing number
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // Found the repeating number
                result[0] = nums[i];
            } else if (nums[i] != nums[i - 1] + 1) {
                // Found the missing number (gap in sequence)
                result[1] = nums[i - 1] + 1;
            }
        }

        // Check if the missing number is at the end
        if (result[1] == 0) {
            result[1] = nums.length;
        }

        return result;
    }

    /**
     * Optimal O(n) time, O(1) extra space solution using XOR partitioning.
     * Returns int[2] where result[0] = repeating number, result[1] = missing number
     */
    public static int[] findRepeatingAndMissingOptimal(int[] nums) {
        int n = nums.length;

        // Step 1: XOR all array elements and numbers from 1..n
        int xor = 0;
        for (int num : nums) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;

        // xor now is repeating ^ missing
        // Step 2: Find a set bit (rightmost set bit)
        int setBit = xor & -xor;

        // Step 3: Partition numbers into two groups and XOR separately
        int x = 0, y = 0; // will hold the two distinct results
        for (int num : nums) {
            if ((num & setBit) != 0) x ^= num; else y ^= num;
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) x ^= i; else y ^= i;
        }

        // x and y are the repeating and missing numbers in unknown order
        int repeating, missing;
        // Determine which one is actually repeating by checking array
        boolean xIsRepeating = false;
        for (int num : nums) {
            if (num == x) { xIsRepeating = true; break; }
        }
        if (xIsRepeating) {
            repeating = x; missing = y;
        } else {
            repeating = y; missing = x;
        }

        return new int[] { repeating, missing };
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 6, 7, 5, 7 };
        int[] result = findRepeatingAndMissing(nums);
        System.out.println("Repeating: " + result[0] + ", Missing: " + result[1]);
        System.out.println(Arrays.toString(result));
    }

}
