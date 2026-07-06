
import java.util.Arrays;
import java.util.PriorityQueue;

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
            // Compare by length first
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                // If same length, compare lexicographically
                return a.compareTo(b);
            }
        });

        return nums[nums.length - k];
    }

    //Using PriorityQueue (Min-Heap) to find the kth largest number without sorting the entire array
    public String kthLargestNumberPQ(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        return minHeap.peek(); // The root of the heap is the kth largest
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        System.out.println(sol.kthLargestNumber(nums, k)); // Output: "3"
        System.out.println(sol.kthLargestNumberFixed(nums, k)); // Output: "3"
    }
}


/*
If it's aray of integer instead of string, then ?

Ah! If the input is an array of integers instead of strings, the problem becomes much simpler because 
you don’t need to worry about numeric comparison via string length or lexicographical order. You can use regular sorting or a heap.

Here’s how:

✅ Approach 1: Sort the Array
import java.util.*;

class Solution {
    public int kthLargestNumber(int[] nums, int k) {
        Arrays.sort(nums); // ascending order
        return nums[nums.length - k]; // k-th largest
    }
}


If it's aray of integer instead of string, then ?

Ah! If the input is an array of integers instead of strings, the problem becomes much simpler because you don’t need to worry about numeric comparison via string length or lexicographical order. You can use regular sorting or a heap.

Here’s how:

✅ Approach 2: Min-Heap (better if k << n)
import java.util.*;

class Solution {
    public int kthLargestNumber(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // min-heap

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }

        return heap.peek(); // root of min-heap is k-th largest
    }
}
⏱ Complexity
Time: O(n log k)
Space: O(k)

*/





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