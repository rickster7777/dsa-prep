import java.util.Map;

public class SolMap {
    public static <K> void findThirdMax(Map<K, Integer> map) {

        if (map.size() < 3) {
            System.out.println("Less than 3 distinct values");
            return;
        }

        K firstKey = null, secondKey = null, thirdKey = null;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            K key = entry.getKey();

            if (value > first) {
                third = second;
                thirdKey = secondKey;
                second = first;
                secondKey = firstKey;
                first = value;
                firstKey = key;

            } else if (value > second && value < first) {
                third = second;
                thirdKey = secondKey;
                second = value;
                secondKey = key;

            } else if (value > third && value < second) {
                third = value;
                thirdKey = key;
            }
        }

        if (thirdKey == null) {
            System.out.println("No 3rd distinct maximum");
        } else {
            System.out.println("3rd Max: " + thirdKey + " -> " + third);
        }
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
    }
}
