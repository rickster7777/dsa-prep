public class Solution {
    public static int addMinimum(String word) {
    int insertions = 0;
    int i = 0;

    while (i < word.length()) {
        if (word.charAt(i) == 'a') {
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
                // Just "a" or something else
                insertions += 2;
                i += 1;
            }
        } else if (word.charAt(i) == 'b') {
            // Missing "a" before and "c" after
            if (i + 1 < word.length() && word.charAt(i + 1) == 'c') {
                insertions += 1; // missing "a"
                i += 2;
            } else {
                insertions += 2; // missing "a" and "c"
                i += 1;
            }
        } else if (word.charAt(i) == 'c') {
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
    }
}
