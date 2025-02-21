package Collections.LinkedListDemo;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Element at index 2: " + linkedList.get(2)); // O(n)
        linkedList.addLast(4); // O(1)
        linkedList.addFirst(0); // O(1)

        System.out.println("Element at first index: " + linkedList.getFirst());
        System.out.println("Element at last index: " + linkedList.getLast());

        System.out.println(linkedList);

        linkedList.removeIf(x -> x % 2 == 0);
        System.out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}