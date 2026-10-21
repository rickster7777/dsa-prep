import java.util.Arrays;

/*
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
*/
/*
// Approach
S.C: O(n)
T.C: O(1)

The key observation is:

For each character, only its first occurrence and current occurrence matter.

As you scan the string:

1. Keep an array first[26] storing the first index where each character appeared.
2. If this is the first time seeing the character → store its index.
3. If you've seen it before → calculate:
 currentIndex - firstIndex - 1
4. Keep the maximum.

Time:  O(n)
Space: O(1)

*/
public class Main {

	// === Students implement only this method ===
    public static int MaxLengthBetweenEqualCharacters(String s) {
        // Step 1: Prepare an array to store the first index of each lowercase letter.
        int n = s.length();
        int i = 0;
        int[] freq = new int[26];
        Arrays.fill(freq, -1); // filling -1 to indicate that no letter has been seen yet.
        // it cant be left as 0 because 0 is a valid index and we need to differentiate between seen and unseen letters.

        // Keep -1 when no matching pair has been found yet.
        int largest = -1;

        // Step 2: Scan each character in the string once.
        while(i < n) {
            int index = freq[s.charAt(i) - 'a'];

            if( index != -1) {
                // Step 3: For a repeated letter, count only the characters between its occurrences.
                int len = i - index -1;
                largest = Math.max(largest, len);
            }else {
                // Step 4: Save the first occurrence so later repeats use the widest possible gap.
                freq[s.charAt(i) - 'a'] = i;
            }
           i++;
        }

        // Step 5: Return the longest gap, or -1 if no letter appeared twice.
        return largest;
    }
}