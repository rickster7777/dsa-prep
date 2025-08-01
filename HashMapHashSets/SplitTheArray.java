package HashMapHashSets;

import java.util.*;

public class SplitTheArray {

    public static boolean split(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        boolean found = map.values().stream().anyMatch(val -> val > 2);

        return found;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4 };
        System.out.println(SplitTheArray.split(arr));
    }

}
