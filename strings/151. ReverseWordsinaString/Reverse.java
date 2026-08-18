/*
this was kept in 2 pointers reverse swapping folder
*/
public class Reverse {
    public static String reverseWordss(String input) {
        String[] chars = input.split(" ");

        System.out.println(chars);
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {

            /*
              if (chars[start] == " " || chars[end] == " ") {
                continue;
            }
            comparing strings using == checks for reference equality, not content equality.
            In Java, strings are objects, and using == checks if both references point to the same

           continue can still cause an infinite loop because it doesn't advance start/end.
Simplest safe fix: split on whitespace and remove the skip logic (same approach as reverseWordssfixed).
            */
            if (" ".equals(chars[start]) || " ".equals(chars[end])) {
                continue;
            }
            String temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return String.join(" ", chars).trim();

    }

    public static String reverseWordssfixed(String input) {
        // Split on one or more spaces using regex "\\s+"
        String[] words = input.trim().split("\\s+");

        // Reverse the array in-place
        int start = 0;
        int end = words.length - 1;
        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }

        // Join the reversed words with a single space
        return String.join(" ", words);
    }

    /*
     * ⏱ Time Complexity
     * trim() → O(n)
     * split("\\s+") → O(n)
     * Reversing array → O(k) (k = number of words)
     * String.join() → O(n)
     * ✅ Overall Time: O(n)
     * 
     * 💾 Space Complexity
     * split() creates an array of words → O(n)
     * No extra data structure for reversing (in-place swap)
     * ✅ Overall Space: O(n)
     */
    // included below function After the TUF list
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();

        String[] arr = s.trim().split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            str.append(arr[i] + " ");
        }
        return str.toString().trim();
    }

    /*
     * ⏱ Time Complexity
     * trim() → O(n)
     * split() → O(n)
     * Loop through words → O(k)
     * toString() → O(n)
     * ✅ Overall Time: O(n)

     * 💾 Space Complexity
     * split() array → O(n)
     * StringBuilder → O(n)
     * ✅ Overall Space: O(n)
     */
    public static void main(String[] args) {
        String input = "a good   example";
        String output = Reverse.reverseWordssfixed(input);
        System.out.println(output); // example good a
    }
}
