package Collections.IdentityHashMapDemoVideo11;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        //Map<String, Integer> map = new IdentityHashMap<>();

        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("Rishav");
        String key2 = new String("Rishav");

        System.out.println(System.identityHashCode(key1));//Plays with the reference
        System.out.println(System.identityHashCode(key2));//Plays with the reference


        System.out.println(key1.hashCode());//Plays with the content
        System.out.println(key2.hashCode());//Plays with the content
        map.put(key1, 90);
        map.put(key2, 90);
        System.out.println(map);

    }
}