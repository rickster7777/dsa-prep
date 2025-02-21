package Collections.CopyOnWriteArrayListDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // "Copy on Write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that
        // copy
        // This ensures that other threads reading the list while it’s being modified
        // are unaffected.

        // Read Operations: Fast and direct, since they happen on a stable list without
        // interference from modifications.
        // Write Operations: A new copy of the list is created for every modification.
        // The reference to the list is then updated so that subsequent reads use this
        // new list.

        // notepad --> notepad-copy

        // read more
        //List<String> shoppingList = new ArrayList<>();
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List: " + shoppingList);

        for (String item : shoppingList) {
            System.out.println(item);
            // Try to modify the list while reading
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }
        // purani = new
        System.out.println("Updated Shopping List: " + shoppingList);

        /*
         * In above code if ArrayList is used instead of CopyOnWriteArrayList it gives
         * following exception.
         * 
         * Exception in thread "main" java.util.ConcurrentModificationException
         * at
         * java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
         * at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
         * at Collections.CopyOnWriteArrayListDemo.CopyOnWriteArrayListDemo.main(
         * CopyOnWriteArrayListDemo.java:34)
         * 
         * because arrayList are stable it doesn't allow modifications at the time of reading.
         */

    }
}
