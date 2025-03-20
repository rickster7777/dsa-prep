public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;  // Move pointer in s when a match is found
            }
            j++;  // Always move pointer in t
        }

        return i == s.length();  // If i reaches end of s, it is a subsequence
    }

    public boolean isSubsequence1(String s, String t) {
        int sptr = 0, i = 0;

        while (i < t.length()) {
            if (sptr < s.length() && s.charAt(sptr) == t.charAt(i)) {
                sptr++;
            }
            if (sptr == s.length()) {
                return true;
            }
            i++;
        }

        return sptr == s.length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // false
    }
}
