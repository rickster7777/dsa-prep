package sliding window.Frequency-Based Window (HashMap).567. Permutation in String;

import java.util.Arrays;

/*
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] freq = new int[26];

        for (char c : s2.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s1.toCharArray()) {
            freq[c - 'a']--;
        }

        for (char c : s1.toCharArray()) {
            if (freq[c - 'a'] != 0) {
                return false;
            }
        }

        int windowSize = s1.length();
        int left = 0, right = 0, n = s2.length();

        while (right < n) {
            
            if(right - left + 1 == windowSize){

                boolean isAna = checkAnagram(s1, s2.substrig(left, right));

                if(isAna) return true;

                left++;
            }
            i++;

        }

        return false;
    }
}

Errors in your code

Wrong frequency initialization

for (char c : s2.toCharArray()) {
    freq[c - 'a']++;
}

This counts all characters in s2, which is not useful. You only need the first window of size s1.length() or maintain the counts as the window slides.

Incorrect check

for (char c : s1.toCharArray()) {
    if (freq[c - 'a'] != 0) {
        return false;
    }
}

This only checks characters present in s1. It ignores extra characters that may exist in the window.

Typo

s2.substrig(left, right)

should be

s2.substring(left, right + 1)

since substring()'s second argument is exclusive.

Undefined variable

i++;

should be

right++;
Missing checkAnagram()
You haven't implemented it.
Inefficient approach
Calling checkAnagram() for every window takes O(26) or O(m) each time, leading to O(n × m) in the worst case.
*/


/* 
Efficient Sliding Window (O(n))

Maintain frequency counts for:

need → characters in s1
window → current window in s2
*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        // STEP 1: declare 2 arrays to count frequency
        int[] need = new int[26];
        int[] window = new int[26];

        // STEP 2: Count frequency of s1.
        for (char c : s1.toCharArray())
            need[c - 'a']++;

        //STEP 3: window size
        int k = s1.length();

        //STEP 4: First window check
        for (int i = 0; i < k; i++)
            window[s2.charAt(i) - 'a']++;

        if (Arrays.equals(need, window))
            return true;

        //STEP 5: Slide the window and keep checking for each window
        for (int i = k; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - k) - 'a']--;

            if (Arrays.equals(need, window))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        /*
        Example 1:
        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").

        Example 2:
        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false
        */
    }
}

/*
Time Complexity
Building frequencies: O(m)
Sliding window: O(n)
Comparing two arrays of size 26: O(26) = O(1)

Overall complexity: O(n), where n = s2.length().
*/