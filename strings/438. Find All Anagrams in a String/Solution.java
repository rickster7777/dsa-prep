
import java.util.ArrayList;
import java.util.List;

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
                    list.add(i + 1 - k); //here i+1-k is the starting index of the current window of size k
                    // its added because we want to return the starting index of the anagram in the original 
                    // string s, not the index of the last character in the window.
                    /*
                    Here i + 1 - k and i - k + 1 both will work ?

                    Either one will work. i - k + 1 is slightly more direct, 
                    while i + 1 - k is just the same expression written in a different order.
                    (Asking this because I've used this in the sliding window maximum problem   )
                    */
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
        System.out.println(result); // Output: [0, 6]
        // 1st anagram "cba" starts at index 0, and the 2nd anagram "bac" starts at index 6.
    }
}
