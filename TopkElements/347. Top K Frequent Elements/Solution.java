import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> maxEntry = maxHeap.poll();
            arr[i] = maxEntry.getKey();
        }
        // int[] arr = new int[k]; // k must be defined or passed as a variable

        // Just to get values
        // int max = Integer.MIN_VALUE;
        // int secondMax = Integer.MIN_VALUE;

        // for (int value : map.values()) {
        // if (value > max) {
        // secondMax = max;
        // max = value;
        // } else if (value > secondMax && value != max) {
        // secondMax = value;
        // }
        // }

        // To get key and value max and second max
        // int max = Integer.MIN_VALUE;
        // int secondMax = Integer.MIN_VALUE;
        // int maxKey = Integer.MIN_VALUE;
        // int secondMaxKey = Integer.MIN_VALUE;

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // int val = entry.getValue();
        // int key = entry.getKey();

        // if (val > max) {
        // secondMax = max;
        // secondMaxKey = maxKey;
        // max = val;
        // maxKey = key;
        // } else if (val > secondMax && val != max) {
        // secondMax = val;
        // secondMaxKey = key;
        // }
        // }

        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1,1,1,2,2,3 };
        int k = 2;

        int[] result = sol.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}