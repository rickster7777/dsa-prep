class Solution {
    public String reverseStr(String s, int k) {
        // Convert the string to a character array for in-place editing
        char[] arr = s.toCharArray();

        // Iterate over the string in steps of 2k
        for (int i = 0; i < arr.length; i += 2 * k) {
            // Define the start of the segment to reverse
            int start = i;

            // Define the end of the reversal segment
            // It's either i + k - 1 or end of array
            int end = Math.min(i + k - 1, arr.length - 1);

            // Reverse characters between start and end
            while (start < end) {
                // Swap characters
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        // Convert the character array back to a string
        return new String(arr);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println(solution.reverseStr(s1, k1)); // Output: "bacdfeg"
        // explanation: The first 2k characters are "abcdefg". The first k characters "ab" are reversed to become "ba". 
        // The next k characters "cd" remain the same. The last character "g" remains the same. So the final string is "bacdfeg".
        String s2 = "abcd";
        int k2 = 2;
        System.out.println(solution.reverseStr(s2, k2)); // Output: "bacd"
    }
}
