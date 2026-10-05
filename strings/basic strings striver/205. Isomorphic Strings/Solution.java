import java.util.HashMap;
import java.util.Map;

/*
For a spring to be isomorphic These three conditions are important:

✔ Same length
✔ Same number of distinct characters
✔ Same pattern & One-to-one consistent mapping


Out of the three first is already given in the problem Second can be verified through set

How to match pattern  that is tricky Because in this sequence is important?

To achieve this hash map is used and how it's used That's a highlight.
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>(); // s → t
        Map<Character, Character> mapTS = new HashMap<>(); // t → s

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Check s → t mapping
            if (mapST.containsKey(cs)) {
                if (mapST.get(cs) != ct) return false; // inconsistent mapping
            } else {
                mapST.put(cs, ct);
            }

            // Check t → s mapping
            if (mapTS.containsKey(ct)) {
                if (mapTS.get(ct) != cs) return false; // inconsistent reverse mapping
            } else {
                mapTS.put(ct, cs);
            }
        }

        return true;
    }

    // Hardcoded test harness: provide inputs from code (no stdin).
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example inputs provided here
        String s1 = "egg", t1 = "add";           // expected: true
        String s2 = "foo", t2 = "bar";           // expected: false
        String s3 = "paper", t3 = "title";      // expected: true

        System.out.println(s1 + ", " + t1 + " -> " + solver.isIsomorphic(s1, t1));
        System.out.println(s2 + ", " + t2 + " -> " + solver.isIsomorphic(s2, t2));
        System.out.println(s3 + ", " + t3 + " -> " + solver.isIsomorphic(s3, t3));
    }
}
