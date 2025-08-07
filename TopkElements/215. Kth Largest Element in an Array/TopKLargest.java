import java.util.PriorityQueue;

public class TopKLargest {
    public static int findTopK(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest in top K
            }
        }

        return minHeap.poll();
        // Convert to array
        // int[] result = new int[k];
        // int i = 0;
        // for (int num : minHeap) {
        //     result[i++] = num;
        // }

        //return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3,2,1,5,6,4 };
        int k = 2;

        TopKLargest sol = new TopKLargest();
        int result = TopKLargest.findTopK(nums, k);
        System.out.println(result);
    }
}


/*
✅ Approach 1: Sorting (Baseline)
Time: O(n log n)
Space: O(1) if in-place
Sort the array.

Return the kth largest → at index -k.
This works, but isn't optimal.

✅ Approach 2: Min-Heap (Efficient and Intuitive)
Time: O(n log k)
Space: O(k)
This is the most interview-friendly and practical method when sorting is not allowed.

What's a Min-Heap?
A min-heap is a data structure that always keeps the smallest item at the top. Think of it
like a container that holds k elements, and it always tosses out the smallest one to make room for a larger one.

Steps:
Create a min-heap of size k.
Go through each element in nums.
Add it to the heap.
If the heap size > k, remove the smallest element (to keep only the k largest).
At the end, the top of the heap is the kth largest.

Why does this work?
You're always keeping the k biggest numbers, and the smallest of them is the one you want (the kth largest overall).

✅ Approach 3: Quickselect (Advanced, Most Efficient)
Time: Average O(n)
Worst-case: O(n²)
Space: O(1)
This is based on the QuickSort partition logic. It’s tricky but very efficient.

Instead of fully sorting, we only partition around a pivot to focus on the part of the array that contains the k-th largest.

But it’s more complex and can be unstable in worst cases — use this if you're asked for best performance.
 */