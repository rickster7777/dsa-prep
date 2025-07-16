import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Sol2 {
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0]; // Compare by distance
            } else {
                return b[1] - a[1]; // Tie breaker: larger value removed first
            }
        });

        for (int num : arr) {
            maxHeap.offer(new int[]{Math.abs(num - x), num});
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }

        Collections.sort(result); // Must return sorted result
        return result;
    }
}
