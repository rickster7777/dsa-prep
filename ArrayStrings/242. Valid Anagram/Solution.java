
import java.util.*;

public class Solution {

    public boolean isAnagram(String s, String t) {

        // Map<String, Integer> map = new HashMap<>();
        // for (String i : s.split("")) {
        //     if (map.containsKey(i) && map.get(i) > 0) {
        //         map.put(i, map.get(i) + 1);
        //     } else {
        //         map.put(i, map.getOrDefault(i, 0) + 1);
        //     }
        // }
        // for (String i : t.split("")) {
        //     if (map.containsKey(i) && map.get(i) > 0) {
        //         map.put(i, map.get(i) - 1);
        //     } else {
        //         return false;
        //     }
        // }
        // return true;
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "rat", t = "car";

        System.out.println(sol.isAnagram(s, t));
    }
}

/*
 ✅ What’s Good:
You’re correctly counting the frequency of each character in s and then decrementing it while processing t.

❌ What Can Be Improved:
Redundant check:
The condition:

java
Copy
Edit
if (map.containsKey(i) && map.get(i) > 0) {
    map.put(i, map.get(i) + 1);
} else {
    map.put(i, map.getOrDefault(i, 0) + 1);
}
is redundant. You can just use:

java
Copy
Edit
map.put(i, map.getOrDefault(i, 0) + 1);
Splitting strings:
You’re doing s.split(""), which is inefficient. Better to iterate over char[] using toCharArray().

Use of String as key:
Map<String, Integer> could be Map<Character, Integer> which is cleaner and faster for character-based problems.


 */
