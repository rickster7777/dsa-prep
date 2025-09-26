
import java.util.Arrays;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        // Use Long to handle larger numbers than Integer can hold
        long[] longNums = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            longNums[i] = Long.parseLong(nums[i]);
        }

        Arrays.sort(longNums);
        return String.valueOf(longNums[longNums.length - k]);
    }

    /*
     ✅ Purpose:

This code sorts an array of strings (nums) using a custom comparator with two sorting rules:

Primary rule: Sort by length of the string (shorter strings come first).

Secondary rule (tie-breaker): If lengths are equal, sort by lexicographical order (dictionary order).
     */
    public String kthLargestNumberFixed(String[] nums, int k) {

        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        return nums[nums.length - k];
    }
}
/*
java.lang.NumberFormatException: For input string: "83598933472122816064"
at line 67, java.base/java.lang.NumberFormatException.forInputString
at line 708, java.base/java.lang.Long.parseLong
at line 831, java.base/java.lang.Long.parseLong
at line 8, Solution.kthLargestNumber
at line 56, __DriverSolution__.__helper__
at line 89, __Driver__.main


So, your current approach with int or long parsing just can’t handle this input — because the numbers are arbitrarily large!
To fix your code and keep it close to your original, you cannot convert strings to numeric types.

Instead, you must:
Keep the numbers as strings.
Sort them by their numeric value, without parsing.
Then return the kth largest string.
 */