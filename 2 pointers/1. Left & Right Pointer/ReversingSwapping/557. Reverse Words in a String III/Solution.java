class Solution {
    public String reverseWords(String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // Reverse each word individually
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray(); // convert word to char array

            int start = 0;
            int end = chars.length - 1;

            // Reverse using two-pointer technique
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }

            //THIS IS TO REMEMBER
            words[i] = new String(chars); // convert chars array back to string
        }

        // Join the reversed words with a space
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "Let's take LeetCode contest";
        String output = sol.reverseWords(input);
        System.out.println(output); // Output: "s'teL ekat edoCteeL tsetnoc"
    }
}
/*
 Great thinking! You're asking whether we can use .split("") instead of .toCharArray() in Java when reversing characters in each word.

Let’s clarify the difference and answer your question:

🔍 .toCharArray() vs .split("")
Method	What it Returns	Suitable for Char Reversal?
.toCharArray()	char[] (primitive array)	✅ Yes — can modify characters directly
.split("")	String[] (array of strings)	❌ Not ideal — strings are immutable and heavier

❌ Why .split("") is not ideal here:

String[] chars = word.split("");
This returns an array of String objects, not characters.

You can use it to swap characters, but it's less efficient and adds unnecessary overhead.

You can't use char temp = chars[i]; — because chars[i] is a String, not a char.

✅ Example Using .split("") (Possible, but not recommended):

String[] chars = word.split("");
String temp = chars[start];
chars[start] = chars[end];
chars[end] = temp;
But:

This is heavier in memory (array of objects).

You lose the performance and simplicity of char[].
 */