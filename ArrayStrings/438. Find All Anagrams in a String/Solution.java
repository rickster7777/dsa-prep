
import java.util.*;

// public class Solution {

//     public static List<Integer> findAnagrams(String s, String p) {
//         int k = p.length();
//         List<Integer> list = new ArrayList<>();

//         StringBuilder s1 = new StringBuilder();

//         for (int i = 0; i < s.length(); i++) {
//             s1.append(s.charAt(i));

//             if (s1.length() == k) {
//                 boolean isAna = isAnagram(s1.toString(), p);

//                 if (isAna) {
//                     list.add(i + 1 - k);
//                 }
//                 s1.deleteCharAt(0);
//             }
//         }
//         return list;
//     }

    // private static boolean isAnagram(String s1, String s2) {
    //     // Convert to char arrays, sort them, and compare
    //     char[] c1 = s1.toCharArray();
    //     char[] c2 = s2.toCharArray();
    //     Arrays.sort(c1);
    //     Arrays.sort(c2);
    //     return Arrays.equals(c1, c2);
    // }

//     public static void main(String[] args) {

//         String s = "cbaebabacd", p = "abc";
//         List<Integer> result = findAnagrams(s, p);
//         System.out.println(result); // Output:
//     }
// }

//Above sol gave TLE

/*
🧠 Optimization Tip:
This solution works but is not optimal for large strings because you're rechecking anagrams from scratch in every window.

A better approach uses sliding window + frequency arrays for O(n) performance. Let me know if you want that optimized
version too.
 */

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> list = new ArrayList<>();

        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            s1.append(s.charAt(i));

            if (s1.length() == k) {
                boolean isAna = isAnagram(s1.toString(), p);

                if (isAna) {
                    list.add(i + 1 - k); // Fixed line
                }
                s1.deleteCharAt(0); // Slide the window
            }
        }
        return list;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] freq = new int[26];
        for (char c : a.toCharArray())
            freq[c - 'a']++;
        for (char c : b.toCharArray())
            freq[c - 'a']--;

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result); // Output:
    }
}
