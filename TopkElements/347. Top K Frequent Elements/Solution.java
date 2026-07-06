import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // STEP 1 - Count frequencies using a HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // STEP 2 - Use a Max-Heap (PriorityQueue) to get top k frequent elements
        // PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new
        // PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // One small improvement to your comparator:
        // This avoids potential integer overflow from subtraction, even though
        // frequencies are usually small.
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // STEP 3 - Add all entries from the map to the max heap
        maxHeap.addAll(map.entrySet());

        // STEP 4 - Extract the top k elements from the max heap
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

    // Approach 2

    public int[] topKFrequentApp2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 1, 1, 2, 3, 3 };
        int k = 2;
        // Output: [1,3]
        int[] result = sol.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}