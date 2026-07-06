package HashMapHashSets;

import java.util.HashMap;
import java.util.Map;

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
        int[] arr = { 1, 1,1, 2,2, 2, 3, 4 };
        //Output: true (because 1 and 2 appear more than twice)
        System.out.println(SplitTheArray.split(arr));
    }

}
