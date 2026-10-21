public class Main {

	// === Students implement ONLY this method ===
    public static int LongestCommonSubsequence(String text1, String text2) {
        // TODO: Your Code here
		int i = 0, j = 0, count = 0;;
        int len = Math.max(text1.length(), text2.length());

        while (i < len) {
            if(j == text2.length()){
                return count;
            }
            if (text1.charAt(i) == text2.charAt(j)) {
               // i++;  // Move pointer in s when a match is found
                j++;
                count++;
            }
            i++;  // Always move pointer in t
        }
        return count;
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(LongestCommonSubsequence(text1, text2)); // Output: 3
        // Explanation: The longest common subsequence is "ace" and its length is 3.

        String text3 = "abc";
        String text4 = "abc";
        System.out.println(LongestCommonSubsequence(text3, text4)); // Output: 3
        // Explanation: The longest common subsequence is "abc" and its length is 3.
    }
}