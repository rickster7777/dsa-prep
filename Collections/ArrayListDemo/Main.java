package Collections.ArrayListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// import reel.sort;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // List<Integer> list1 = new List<>();
        // Above line is incor rect because List is an interface in Java, and you cannot
        // instantiate an interface directly.
        // You need to use a class that implements the List interface, such as ArrayList
        // or LinkedList.
        // Here's how you can fix it:

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        // System.out.printf(list.getClass().getName()," ",list);
        System.out.println(list.getClass().getName() + " " + list);
        System.out.println(arrayList.getClass().getName() + " " + arrayList);

        System.out.println("Element at index: " + arrayList.get(2));
        System.out.println("Fetching size of the arraylist: " + arrayList.size());

        // iterating over a list
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        list.remove(1);
        // You can directly iterate over the list like this
        for (int x : list) {
            System.out.println(x);
        }

        list.add(1, 5);
        for (int x : list) {
            System.out.println(x);
        }

        // To check existence of an element
        System.out.println(list.contains(2));
        System.out.println(list.contains(5));

        ArrayList<Integer> int1 = new ArrayList<>(11);
        System.out.println("Size of int1 array list: " + int1.size());
        /*
         * In Java, the ArrayList class does not provide a direct method to access its
         * capacity (the number of elements it can hold
         * before resizing). The size() method only returns the number of elements in
         * the list, not the capacity.
         * 
         * However, if you're interested in knowing the current capacity of an
         * ArrayList, you would have to use reflection or a workaround
         * because ArrayList doesn't provide a built-in method for this.
         */

        // instanceof Operator: You can use the instanceof operator to check if an
        // object is an instance of a particular class or interface.

        String str = "Hello";
        if (str instanceof String) {
            System.out.println("It's a String!");
        }

        /*
         * CONCEPT OF asList
         * add and remove doesn't work in asList case it returns a fixed size list.
         * but .set(); can be used to update the existing values.
         */

        List<String> list2 = new ArrayList<>();
        System.out.println(list2.getClass().getName());

        List<String> list3 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list3.getClass().getName());

        String[] array = { "Apple", "Banana", "Cherry" };
        List<String> list4 = Arrays.asList(array);
        System.out.println(list4.getClass().getName());

        /*
         * Another way to create a list.
         * add, remove, set nothing can be used in this process of creating a list.
         */
        List<Integer> list5 = List.of(1, 2, 3, 4);

        /*
         * Remove by value or by index.
         */

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Strawberry");

        System.out.println(fruits);

        // Removing by index
        fruits.remove(2);
        System.out.println(fruits);

        // Removing by value
        fruits.remove("Date");
        System.out.println(fruits);

        /*
         * How it's hadled in case of integer.
         */

        List<Integer> list6 = new ArrayList<>();
        list6.addAll(list5);

        list6.remove(1);
        System.out.println(list6);

        //removing by value
        list6.remove(Integer.valueOf(1));
        System.out.println(list6);

        /*
         * toArray
         */
        Object[] array1 = list.toArray();
        System.out.println(array1);

        Integer[] array2 = list6.toArray(new Integer[0]);
        System.out.println(array2);
    }

}