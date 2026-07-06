import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class collectionMethod {
    public static void main(String[] args) {
        // Your code here

        List<Integer> list = Arrays.asList(5, 3, 1, 6, 2, 4);

        Collections.sort(list);
        /*
        SORTED SET
        Set<Integer> set = new TreeSet<>(Arrays.asList(5,3,1,6));

        ✅ Sorted Map
        Map<Integer, String> map = new TreeMap<>();
        */
       
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        List<Integer> search = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(Collections.binarySearch(search, 5));
        /*
        👉 Alternatives:
        For Set: use set.contains(value)
        For Map: use map.containsKey(key)
        */

        Collections.rotate(list, 3);
        System.out.println("Rotated -> "+list);

        int[] arr = list.stream().
            mapToInt(Integer::intValue).
            toArray();
        /*
        ✔ THIS Works for:
        List
        Set:  set.stream().mapToInt(Integer::intValue).toArray();
        Map (but you must stream keys/values)
        int[] arr = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        */
        System.out.println("To Array; -> "+arr);
    }
}