/*
Example 1:

Input: arr1 = [1,10,100], arr2 = [1000]
Output: 3
Explanation: There are 3 pairs (arr1[i], arr2[j]):
- The longest common prefix of (1, 1000) is 1.
- The longest common prefix of (10, 1000) is 10.
- The longest common prefix of (100, 1000) is 100.
The longest common prefix is 100 with a length of 3.

Example 2:
Input: arr1 = [1,2,3], arr2 = [4,4,4]
Output: 0
Explanation: There exists no common prefix for any pair (arr1[i], arr2[j]), hence we return 0.
Note that common prefixes between elements of the same array do not count.


My Approach:
1. Sort the array
2. Start a nested loop to track both arrays from behind.
3. Separate function to check if two elements at index i and j are prefixed.
4. The first prefix found will be the longest.
 */

public class Solution {
    // Helper function to find the longest common prefix between two integers
    private static int commonPrefixLength(int a, int b) {
        // Convert both integers to strings
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        // Find the length of the shortest string
        int minLength = Math.min(strA.length(), strB.length());

        // Compare digits and find the longest common prefix
        int i = 0;
        while (i < minLength && strA.charAt(i) == strB.charAt(i)) {
            i++;
        }

        return i; // The length of the common prefix
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxPrefixLength = 0;

        // Iterate over each pair (arr1[i], arr2[j])
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                // Find the common prefix length for arr1[i] and arr2[j]
                int prefixLength = commonPrefixLength(arr1[i], arr2[j]);
                // Update the maximum prefix length
                maxPrefixLength = Math.max(maxPrefixLength, prefixLength);
            }
        }

        return maxPrefixLength;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };
        System.out.println(longestCommonPrefix(arr1, arr2)); // Output: 3

        // Test case 2
        int[] arr3 = { 1, 2, 3 };
        int[] arr4 = { 4, 4, 4 };
        System.out.println(longestCommonPrefix(arr3, arr4)); // Output: 0
    }
}
