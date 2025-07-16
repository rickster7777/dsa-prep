
class Solution {
    public void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;
        char temp = '\0';
        String a = "";

        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        sol.reverseString(s);
        System.out.println(s);
    }
}