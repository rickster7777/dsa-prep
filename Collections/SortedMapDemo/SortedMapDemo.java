package Collections.SortedMapDemo;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;


//Video 13
public class SortedMapDemo {
    public static void main(String[] args) {

        /*
         * There are 3 ways to implement TreeMap:
         * Map<> is used if the motive is only to sort it by key.
         * 
         * SortedMap<> provides different set of functions which aren't available in Map
         * or NavigableMap.
         * if that kind of function are in the requirement then that should be ideal
         * choice.
         * 
         * same goes in case of NavigableMap.
         * 
         * 
         * Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);
         * SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
         * NavigableMap<Integer, String> navigableMap = new TreeMap<>();
         */
        SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");
        map.get(77);
        map.containsKey(78);
        map.containsValue(77);

        // System.out.println(map);
        // System.out.println(map.firstKey());
        // System.out.println(map.lastKey());
        // System.out.println(map.headMap(91)); // exclude
        // System.out.println(map.tailMap(91));

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.ceilingKey(3));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.descendingMap());
    }
}