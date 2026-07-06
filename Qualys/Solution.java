/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with length 3.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Implementation for finding the length of the longest substring without
        // repeating characters
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int max = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;

                max = Math.max(max, set.size());
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            // set.remove(s.charAt(left));

            // set.remove(Character.valueOf(s.charAt(left)));
        }

        return max;
    }

    public static int secondLargest(int[] nums) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else {

                if (num > secondLargest && num < largest) {
                    secondLargest = num;
                }
            }
        }
        return secondLargest;
    }

    public static String reverseWordsString(String str) {

        String[] s = str.trim().split("\\s+");

        int left = 0, right = s.length - 1;

        while (left <= right) {

            String temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        return String.join(" ", s);
    }

    public static String reverseStrings(String str) {
        char[] arr = str.toCharArray();

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;

        }

        return new String(arr);
    }

    public static boolean isPalindrome(String s) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
            return true;
        }
        return false;

    }

    public static int[] twoSum(int target, int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                return new int[] { map.get(comp), i };
            }

            map.put(nums[i], i);

        }
        return new int[] {};
    }

    public static boolean checkAnagrams(String s, String t) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int num : freq) {
            if (num > 0) {
                return false;
            }
        }

        return true;
    }

    public static int mostFrequent(int[] nums) {

        int[] freq = new int[10];

        for (int num : nums) {
            freq[num]++;
        }

        int freqCount = 0;

        int maxFreq = 0;
        int result = 0;
        for (int i = 0; i < freq.length; i++) {

            // if (freq[i] > freqCount) {
            // freqCount = i;
            // }

            // corrected approach

            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = i;
            }
        }
        return result;

    }

    public static int mostFrequentSec(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int freqCount = 0, freqkey = 0;

        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() > freqCount) {
                freqCount = mapEntry.getValue();
                freqkey = mapEntry.getKey();
            }
        }
        return freqkey;
    }

    public static int mostFrequentThird(int[] nums) {

        java.util.Arrays.sort(nums);

        int  maxFreq = 0;
        int i = 0;
        int frequentElement = 0;

        while (i < nums.length) {

            int current = nums[i];
            int freqCount = 0; // RESETTING
            while (i < nums.length && current == nums[i]) {
                i++;
                freqCount++;
            }
            /*
             * Problems
             * 1. freqCount never resets
             * You must reset it for every new number.
             * 
             * 2. Wrong comparison
             * This line:
             * if (maxFreq > freqCount)
             * should be:
             * if (freqCount > maxFreq)
             */
            if (freqCount > maxFreq) {
                maxFreq = freqCount;
                frequentElement = current;
            }

        }

        return frequentElement;
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // String s = "pwwkew";
        // int result = solution.lengthOfLongestSubstring(s);
        // System.out.println("Length of the longest substring without repeating
        // characters: " + result);

        // int[] nums = { 12, 5 };
        // int result1 = Solution.secondLargest(nums);
        // System.out.println("2nd largest number is:" + result1);

        // String s1 = "hello world";
        // System.out.println(Solution.reverseWordsString(s1));

        // String s2 = "hello";
        // System.out.println(Solution.reverseStrings(s2));

        // String s3 = "racecar";
        // System.out.println(Solution.isPalindrome(s3));

        // int target = 9;
        // int[] nums1 = { 1, 2, 3, 7, 5 };

        // System.out.println(Arrays.toString(Solution.twoSum(target, nums1)));

        String s4 = "listenn", s5 = "silent";
        System.out.println(Solution.checkAnagrams(s4, s5));

        int[] nums = { 1, 2, 2, 2, 3 };
        System.out.println("First Approach: " + Solution.mostFrequent(nums));

        System.out.println("Second Approach: " + Solution.mostFrequentSec(nums));

        System.out.println("Third Approach: " + Solution.mostFrequentThird(nums));

    }
}

/*
 * 
 * ✅
 * ❌
 * 
 * Arrays
 * Find the second largest element ✅ (Was thinking about the initial value for
 * the largest and second largest variable It is the integer.min _value)
 * Move all 0s to end ✅
 * Find missing number from (1 to n)✅. n * (n + 1) /2
 * Find duplicates in array ✅ !set.add(num)
 * Remove duplicates in sorted array.✅ first problem in my notion list.
 * Merge 2 sorted arrays ✅ i, j, k 3 variables
 * 
 */

/*
Precise Summary of Your Problem

You do not have an algorithm-understanding problem.

You have a:

state-management and implementation-discipline problem

Your brain:

understands the idea quickly,
recognizes patterns,
visualizes the solution,

but during coding:

variables lose precise meaning,
state transitions are not tracked carefully,
counters/comparisons/resets become inconsistent.

So your code becomes:

“Conceptually correct, mechanically incorrect.”

What Your Mistakes Reveal

Your common mistakes:

wrong variable update
reversed condition
forgetting reset
mixing current state vs best-so-far state

This shows:

good problem-solving ability
weak execution precision
Root Cause

You code using:

intuition

instead of:

explicit state awareness

You think:

“This should work.”

Strong programmers think:

“What is every variable representing at this exact moment?”

What You Are Missing
Loop invariants and state tracking

Meaning:

what must remain true,
what each variable currently means,
when state should reset/update.
Why This Happens Repeatedly

Because you likely focused on:

solving many problems,
learning patterns,
understanding approaches,

instead of:

carefully tracing execution state.
The Fix
Before coding:

Define variables clearly.

Example:

maxFreq -> highest frequency seen so far
currentCount -> frequency of current element
During coding:

Constantly ask:

What does this variable represent RIGHT NOW?
After coding:

Dry run manually using tables.

Track:

indices
counters
updates
resets
Biggest Habit You Need

Move from:

"I understand the algorithm."

to:

"I can precisely control program state."

That transition is what makes strong programmers.

*/