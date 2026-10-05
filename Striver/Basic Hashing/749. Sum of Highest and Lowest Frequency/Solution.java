class Solution {
    public int sumHighestAndLowestFrequency(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;

        int minFreq = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxFreq) {
                maxFreq = m.getValue();
            }

            if (m.getValue() < minFreq) {
                minFreq = m.getValue();
            }

        }
        return minFreq + maxFreq;
    }
}
