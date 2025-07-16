// class Solution {
// public String reverseVowels(String s) {
// int start = 0;
// int end = s.length() - 1;
// char temp = '\0';

// while (start < end) {
// char character = s.charAt(start);

// if (character.toLowerCase() == 'a' || character.toLowerCase() == 'e' ||
// character.toLowerCase() == 'i' || character.toLowerCase() == 'o' ||
// character.toLowerCase() == 'u') {

// temp = s.charAt(start);
// s.charAt(start) = s.charAt(end);
// s.charAt(end) = temp;
// }

// start++;
// end--;
// }
// }
// }
/*
 * ❌ Problems:
 * character.toLowerCase() won't compile: char is a primitive, and doesn’t have
 * methods like toLowerCase() directly. You need to cast it to Character or use
 * Character.toLowerCase(character).

 * You can't assign to s.charAt(i): String in Java is immutable. You need to
 * convert it to a char[] array to modify individual characters.

 * You're not returning anything: Your method is declared public String, but has
 * no return statement.
 */

class Solution {
    public String reverseVowels(String s) {
        // Convert the input string to a character array since strings are immutable in
        // Java
        char[] chars = s.toCharArray();

        int start = 0; // Pointer starting from the beginning
        int end = s.length() - 1; // Pointer starting from the end

        // Loop until the two pointers meet
        while (start < end) {

            // Move the start pointer forward until a vowel is found
            while (start < end && !isVowel(chars[start])) {
                start++;
            }

            // Move the end pointer backward until a vowel is found
            while (start < end && !isVowel(chars[end])) {
                end--;
            }

            // Swap the vowels at start and end
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // Move both pointers towards the center
            start++;
            end--;
        }

        // Convert the character array back to a string and return it
        return new String(chars);
    }

    /**
     * Helper method to check if a character is a vowel (case-insensitive).
     */
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c); // Convert character to lowercase for comparison
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}