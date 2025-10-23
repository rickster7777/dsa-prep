
/*
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.


Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

 */


class Solution {

    // My solution
    public int lengthOfLastWord(String s) {
        String[] sLength = s.split(" ");

        return sLength[sLength.length - 1].length();
    }

    //Eff solution
    public int lengthOfLastWordEff(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}


