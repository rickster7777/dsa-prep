
/*1838. Frequency of the Most Frequent Element

Example 1: Input: nums = [1,2,4], k = 5 

Output: 3 

Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4]. 
4 has a frequency of 3. 


Example 2: Input: nums = [1,4,8,13], k = 5 

Output: 2 

Explanation: There are multiple optimal solutions: - 
Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2. - Increment the second element four times to make nums = [1,8,8,13]. 
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
}
