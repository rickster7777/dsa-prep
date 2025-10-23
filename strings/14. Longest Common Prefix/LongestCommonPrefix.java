
/*
My Approach:
Pick first two or first and last words and match their chars if it's same.
no need to check for all the words

Why does this work?

If the first and last words share a common prefix, then all the other words (if they are sorted) will either share a prefix with the first and last words or have a shorter common prefix.

This is because the array is sorted lexicographically, and if the first and last words are aligned, the middle words will at least share the common prefix with them.


what if the array is not sorted 
i dont think array is sorted in this leetcode prob
*/

public class LongestCommonPrefix {

    // Function to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize the prefix with the first string
        String prefix = strs[0];

        // Iterate through all the strings in the array
        for (int i = 1; i < strs.length; i++) {
            // Update the prefix by comparing with the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // Test the function
    public static void main(String[] args) {
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2)); // Output: ""
    }
}
