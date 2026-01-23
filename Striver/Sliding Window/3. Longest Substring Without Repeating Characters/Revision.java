import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class Revision {
    //My Approach
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0, maxLen = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            right++;
        }

        return maxLen;
    }


    //Corrected Approach
    public int lengthOfLongestSubstringFix(String s) {
        int left = 0, right = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, set.size());
                right++; // move right ONLY here
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    //⭐ Even Better (Optimized with HashMap)
    public int lengthOfLongestSubstringHash(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
You’re very close, but this implementation is NOT fully correct ❌
There’s a subtle logic bug in how right is moved.

🚨 What’s Wrong?

You always increment right, even when a duplicate is found.
When a duplicate is detected, you must shrink the window first until the duplicate is removed — without moving right.

Why?
Because right advances even though the duplicate 'b' is still in the window.

✅ Correct Sliding Window Logic

You should:
Move right only when the character is unique
Move left when a duplicate exists
✅ Fixed Version (Minimal Change)
*/