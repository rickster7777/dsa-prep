import java.util.Map;
import java.util.PriorityQueue;

public class SolPq {

    public static <K> void findThirdMax(Map<K, Integer> map) {

        if (map.size() < 3) {
            System.out.println("Less than 3 distinct values");
            return;
        }
        PriorityQueue<Map.Entry<K, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        maxHeap.poll(); // 1st
        maxHeap.poll(); // 2nd
        Map.Entry<K, Integer> third = maxHeap.poll();

        if (third != null) {
            System.out.println("3rd Max: " + third.getKey() + " -> " + third.getValue());
        } else {
            System.out.println("No 3rd distinct maximum");
        }

    }

    public static <K> Map.Entry<K, Integer> findKthMax(Map<K, Integer> map, int k) {

        PriorityQueue<Map.Entry<K, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        return minHeap.size() == k ? minHeap.peek() : null;
    }


    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "a", 5,
                "b", 3,
                "c", 9,
                "d", 1,
                "e", 7
        );

        findThirdMax(map);

        int k = 4;
        Map.Entry<String, Integer> kthMax = findKthMax(map, k);


        if (kthMax != null) {
            System.out.println(k + "th Max: " + kthMax.getKey() + " -> " + kthMax.getValue());
        } else {
            System.out.println("Less than " + k + " distinct values");
        }
    }
}
