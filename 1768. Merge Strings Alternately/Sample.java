
public class Sample {
    public static String mergeAlternately(String word1, String word2) {
        int ptr1 = word1.length();
        int ptr2 = word2.length();

        int wordsize = ptr1;

        if (wordsize < ptr2) {
            wordsize = ptr2;
        }

        int i = 0;

        String finalWord = "";

        while (i < wordsize) {
            if (i < ptr1) {
                finalWord += word1.charAt(i);
            }

            if (i < ptr2) {
                finalWord += word2.charAt(i);
            }

            i++;
        }
        return finalWord;
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }
}

// more optimized approach

/*
 * The code you provided works, but it can be optimized in several ways to
 * improve both performance and readability. Specifically, the following areas
 * can be optimized:
 * 
 * String Concatenation: In Java, using += to concatenate strings inside a loop
 * is inefficient because strings are immutable, and each concatenation creates
 * a new string. A more efficient approach is to use a StringBuilder, which is
 * mutable and designed for string concatenation in loops.
 * 
 * Length Calculation: You calculate ptr1 and ptr2 to store the lengths of word1
 * and word2, but the lengths can be directly accessed inside the loop without
 * needing extra variables. You can use Math.max() to simplify the logic for
 * determining the larger length of the two words.
 * 
 * Overall Simplicity: You can simplify the logic slightly to make it more
 * compact without changing its structure.
 * 

public static String mergeAlternately(String word1, String word2) {
    // Use StringBuilder for efficient string concatenation
    StringBuilder finalWord = new StringBuilder();

    int ptr1 = 0, ptr2 = 0;
    int len1 = word1.length(), len2 = word2.length();

    // Iterate until both pointers reach the end of the strings
    while (ptr1 < len1 || ptr2 < len2) {
        // Append characters alternately from both words
        if (ptr1 < len1) {
            finalWord.append(word1.charAt(ptr1));
            ptr1++;
        }

        if (ptr2 < len2) {
            finalWord.append(word2.charAt(ptr2));
            ptr2++;
        }
    }

    return finalWord.toString();
}

*
 */