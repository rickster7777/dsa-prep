package Collections.StackDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        //1st approach Implementing stack.
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack elements: " + stack);

        Integer removedElement = stack.pop();
        System.out.println("Stack elements after removing last element:" + stack);

        // It gives the last element
        Integer peek = stack.peek();
        System.out.println("Last element of stack:" + peek);

        System.out.println(stack);
        System.out.println("Checking i stack is empty" + stack.isEmpty());
        System.out.println("Size of the stack: " + stack.size());

        int search = stack.search(3);
        System.out.println("Searching for value 3: " + search);
        // 4
        // 3
        // 2
        // 1

        // 2nd approach Implementing LL as stack.
        // linkedlist as stack

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.getLast();// peek
        linkedList.removeLast(); //pop
        linkedList.size();
        linkedList.isEmpty();


        // 3rd approach Implementing LL as stack.
        // ArrayList<Integer> arrayList = new ArrayList<>();
        // arrayList.add(1);
        // arrayList.add(2);
        // arrayList.add(3);
        // arrayList.get(arrayList.size() - 1); // peek
        // arrayList.remove(arrayList.size() - 1); // pop

    }
}