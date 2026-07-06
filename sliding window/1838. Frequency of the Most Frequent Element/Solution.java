
/*1838. Frequency of the Most Frequent Element

Example 1: Input: nums = [1,2,4], k = 5 

Output: 3 

Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4]. 
4 has a frequency of 3. 


Example 2: Input: nums = [1,4,8,13], k = 5 

Output: 2 

Explanation: There are multiple optimal solutions: - 
Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2. -
 Increment the second element four times to make nums = [1,8,8,13]. 
8 has a frequency of 2. - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2. 


Example 3: Input: nums = [3,9,6], k = 2 Output: 1
Algorithm (Sliding Window)

Sort nums

Use two pointers left and right

Keep the sum of the current window

While the cost to make all elements equal to nums[right] exceeds k, move left

Track the maximum window size

Cost Formula

For window [left ... right]:

cost = nums[right] * window_size - window_sum
*/

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long windowSum = 0; // use long to avoid overflow
        int left = 0;
        int maxFreq = 1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            // If cost exceeds k, shrink the window
            while ((long) nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 4 };
        int k = 5;
        System.out.println(sol.maxFrequency(nums, k)); // Output: 3
        // Explanation: Increment the first element three times and the
        // second element two times to make nums = [4,4,4].
        // 4 has a frequency of 3.

        int[] nums2 = { 1, 4, 8, 13 };
        int k2 = 5;
        System.out.println(sol.maxFrequency(nums2, k2)); // Output: 2
        // Explanation: There are multiple optimal solutions: -
        // Increment the first element three times to make nums = [4,4,8,13].
        // 4 has a frequency of 2. - Increment the second element four times to make
        // nums = [1,8,8,13].
        // 8 has a frequency of 2. - Increment the third element five times to make nums
        // = [1,4,13,13].
        // 13 has a frequency of 2.
    }
}

/*
How it works

After sorting:
Arrays.sort(nums);
you try to make all elements in the current window equal to nums[right].

For a window:
[left ... right]
target value = nums[right]

Required operations:
nums[right]×windowSize−windowSum
You check whether that cost exceeds k.


nums = [1,4,8,13]
k = 5

Goal:
Find the largest window where all elements can be made equal
to nums[right] using at most k increments.

Formula:
cost = nums[right] * windowSize - windowSum

--------------------------------------------------

right = 0

Window = [1]
windowSum = 1

targetSum = 1 * 1 = 1
cost = 1 - 1 = 0

Valid
maxFreq = 1

--------------------------------------------------

right = 1

Window = [1,4]
windowSum = 5

targetSum = 4 * 2 = 8
cost = 8 - 5 = 3

Operations:
1 -> 4 = 3

Valid because 3 <= 5
maxFreq = 2

--------------------------------------------------

right = 2

Window = [1,4,8]
windowSum = 13

targetSum = 8 * 3 = 24
cost = 24 - 13 = 11

Operations:
1 -> 8 = 7
4 -> 8 = 4

Total = 11 > 5

Invalid -> shrink window

Remove 1:
windowSum = 12
left++

New Window = [4,8]

targetSum = 8 * 2 = 16
cost = 16 - 12 = 4

Valid
maxFreq = 2

--------------------------------------------------

right = 3

Window = [4,8,13]
windowSum = 25

targetSum = 13 * 3 = 39
cost = 39 - 25 = 14

Invalid -> shrink window

Remove 4:
windowSum = 21
left++

New Window = [8,13]

targetSum = 13 * 2 = 26
cost = 26 - 21 = 5

Valid
maxFreq = 2

--------------------------------------------------


--------------------------------------------------
Final Answer = 2

Key Idea:
After sorting, nums[right] is the largest element.
We try to raise all smaller elements in the window
to nums[right].

cost = requiredSum - currentWindowSum
*/