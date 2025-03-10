package Collections.ImmutableMapDemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        // Initializing a mutable map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // METHOD 1: Creating an unmodifiable map (you can't modify it)
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println("Unmodifiable map: " + map2);
        // map2.put("C", 3); // Uncommenting this line will throw an UnsupportedOperationException

        // METHOD 2: Using Map.of() to create an immutable map (you can't modify it)
        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 89);
        System.out.println("Map created using Map.of: " + map3);
        // map3.put("Akshit", 88); // Uncommenting this line will throw an UnsupportedOperationException

        // METHOD 3: Using Map.ofEntries() to create an immutable map (you can't modify it)
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek", 99));
        System.out.println("Map created using Map.ofEntries: " + map4);
        // map4.put("Vikram", 100); // Uncommenting this line will throw an UnsupportedOperationException
    }
}
