/*

1. Took 25 mins to solve it
2. was writing new HashMap<>(); instead of new LinkedHashMap<>();
3. wsn't able to figure out initially took 10 mins in this

Input: nums = [4, 4, 5, 5, 6]

Output: 4

Explanation: Both 4 and 5 appear twice, but 4 is smaller. So, 4 is the most frequent element.

*/

class Solution {
    public int mostFrequentElement(int[] nums) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxKey = Integer.MAX_VALUE;
        int maxValue = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {

            if (m.getValue() >= maxValue) {
                if (maxValue == m.getValue())
                    maxKey = Math.min(maxKey, m.getKey());
                else {
                    maxKey = m.getKey();
                    maxValue = m.getValue();
                }
            }
        }

        return maxKey;
    }

    // Cleaner

    public int mostFrequentElementcleaner(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxKey = Integer.MAX_VALUE;
        int maxFreq = 0;

        // Find highest frequency
        // If frequencies are equal, choose smaller number
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int num = entry.getKey();
            int freq = entry.getValue();

            // how easily its managed
            if (freq > maxFreq || (freq == maxFreq && num < maxKey)) {
                maxFreq = freq;
                maxKey = num;
            }
        }

        return maxKey;
    }
}
