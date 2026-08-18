public class Solution {
    public static int addMinimum(String word) {
    int insertions = 0;
    int i = 0;
        // Logic to increment i is based on the characters found in the string.
        // For example, if we find "abc", we increment i by 3, 
        // if we find "ab" or "ac" or "bc", we increment i by 2, 
        // and if we find "a" or "b" or "c", we increment i by 1.
    while (i < word.length()) {

        char c = word.charAt(i);

        if (c  == 'a') {
            if (i + 1 < word.length() && word.charAt(i + 1) == 'b') {
                if (i + 2 < word.length() && word.charAt(i + 2) == 'c') {
                    // Found "abc", no insertions
                    i += 3;
                } else {
                    // Found "ab", missing "c"
                    insertions += 1;
                    i += 2;
                }
            } else if (i + 1 < word.length() && word.charAt(i + 1) == 'c') {
                // Found "ac", missing "b"
                insertions += 1;
                i += 2;
            } else {
                // Just "a" or something else because next character is not "b" or "c"
                // Missing "b" and "c"
                insertions += 2;
                i += 1;
            }
        } else if (c == 'b') {
            // Missing "a" before and "c" after
            if (i + 1 < word.length() && word.charAt(i + 1) == 'c') {
                insertions += 1; // missing "a"
                i += 2;
            } else {
                insertions += 2; // missing "a" and "c"
                i += 1;
            }
        } else { //(c == 'c')
            // Missing "a" and "b" before
            insertions += 2;
            i += 1;
        }
    }

    return insertions;
}
    public static void main(String[] args) {
        String word = "b";
        int result = addMinimum(word);
        System.out.println(result); // Output: 2

        // string is valid if it is in the form of "abc" or "aabbcc" or "aaabbbccc" and so on,
        // explanation: we need to add "a" before "b" and "c" after "b" to make it valid, so total 2 insertions are needed.

        String word2 = "aaa";
        int result2 = addMinimum(word2);
        System.out.println(result2); // Output: 6
        // explanation: we need to add "b" and "c" after each "a", so total 6 insertions are needed.
        String word3 = "abc";
        int result3 = addMinimum(word3);
        System.out.println(result3); // Output: 0
        // explanation: the string "abc" is already valid, so no insertions are needed.
    }
}
