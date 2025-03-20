
class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0; // Position where we will write the compressed string
        int readIndex = 0; // To read through the array

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex]; // Current character
            int count = 0;

            // Count how many times the current character repeats consecutively
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character to the result
            chars[writeIndex++] = currentChar;

            // If count is greater than 1, we need to write the count as well
            if (count > 1) {
                // Convert count to a string and write each digit
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
        }

        // Return the new length of the array after compression
        return writeIndex;
    }
}