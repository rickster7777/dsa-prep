//was not able to compare adjacent strings in the array

import java.util.*;

public class Solution {
 // provide the updated logic for non adjacent anagrams only that particular part
 
    public static List<String> removeNonAdjacentAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> seenAnagrams = new HashSet<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            if (!seenAnagrams.contains(signature)) {
                result.add(word);
                seenAnagrams.add(signature);
            }
        }
        return result;
    }

    // For adjacently placed anagrams
    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (result.isEmpty() || !isAnagram(result.get(result.size() - 1), word)) {
                result.add(word);
            }
        }

        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        // Convert to char arrays, sort them, and compare
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        List<String> result = removeAnagrams(words);
        System.out.println(result); // Output: [abba, cd]
    }
}
