import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length < 3){
            int max = Arrays.stream(nums).max().getAsInt();
            return max;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {

            if(!seen.contains(num)){
                minHeap.offer(num);
                seen.add(num);
            }
            if (minHeap.size() > 3) {
                minHeap.poll(); // remove the smallest in top K
            }
        }
        return minHeap.poll();
    }


     public int thirdMaxFixed(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (set.add(num)) {  // add returns false if duplicate
                minHeap.offer(num);
                if (minHeap.size() > 3) {
                    set.remove(minHeap.poll()); // remove smallest
                }
            }
        }

        // If less than 3 distinct elements, return the max
        if (minHeap.size() < 3) {
            while (minHeap.size() > 1) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }


    public int usingSet(int[] nums){

        if(nums.length < 3){
            int max = Arrays.stream(nums).max().getAsInt();
            return max;
        }

        Set<Integer> seen = new HashSet<>();
        for(int num: nums){
            seen.add(num);
        }
        List<Integer> distinctNums = new ArrayList<>(seen);
        Collections.sort(distinctNums, Collections.reverseOrder());
        return distinctNums.size() >= 3 ? distinctNums.get(2) : distinctNums.get(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.thirdMaxFixed(new int[]{3, 2, 1})); // Output: 1
        System.out.println(sol.thirdMaxFixed(new int[]{1, 2})); // Output: 2
        System.out.println(sol.thirdMaxFixed(new int[]{2, 2, 3, 1})); // Output: 1
    }

}



/*
import java.util.PriorityQueue;

class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> seen = new HashSet<>(nums);

        return seen.get(seen.size() - 3);

    }
}

ChatGPT said:
You're on the right track trying to use a set to handle distinct elements in your implementation of thirdMax, but your current code has several issues. Let's walk through them and fix the logic properly.

❌ Issues in Your Code:
new HashSet<>(nums) won't compile — you can't directly pass an int[] array into a HashSet constructor.

Set has no get() method — it's unordered and doesn't support indexing.

seen.get(seen.size() - 3) is invalid because Set doesn't work like a list.

The logic for finding the third maximum is not implemented.
 */