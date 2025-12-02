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

            if (chars[start] == " " || chars[end] == " ") {
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

    // included below function After the TUF list
    public String reverseWords(String s) {

        StringBuilder str = new StringBuilder();

        String[] arr = s.trim().split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            str.append(arr[i] + " ");
        }
        return str.toString().trim();
    }

    public static void main(String[] args) {
        String input = "a good   example";
        String output = Reverse.reverseWordssfixed(input);
        System.out.println(output); // example good a
    }
}
