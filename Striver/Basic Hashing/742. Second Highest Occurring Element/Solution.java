/*
problem
Was not able to figure out to get the second elemnt
But I knew the step 2 part as the same prob is mentioned in Array ->easy

*/

/*
Example 1:
Input: arr = [1, 2, 2, 3, 3, 3]

Output: 2

Explanation:

The number 2 appears the second most (2 times) and number 3 appears the most(3 times). 

Example 2:
Input: arr = [4, 4, 5, 5, 6, 7]

Output: 6

Explanation:

Both 6 and 7 appear second most times, but 6 is smaller.
*/
class Solution {
    public int secondMostFrequentElement(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find highest and second-highest frequency
        int maxFreq = 0;
        int secondMaxFreq = 0;

        for (int freq : map.values()) {

            if (freq > maxFreq) {
                secondMaxFreq = maxFreq;
                maxFreq = freq;
            } 
            else if (freq > secondMaxFreq && freq < maxFreq) {
                secondMaxFreq = freq;
            }
        }

        // No second-most frequent element
        if (secondMaxFreq == 0) {
            return -1;
        }

        // Step 3: Find smallest element with second-highest frequency
        int answer = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq == secondMaxFreq) {
                answer = Math.min(answer, num);
            }
        }

        return answer;
    }
}

