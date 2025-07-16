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
