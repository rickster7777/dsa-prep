package linkedlist.ReverseLinkedList206;

import java.util.LinkedList;

public class Reverse {

    public class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            // TODO Auto-generated constructor stub
            this.data = data;
            this.next = null;
        }

    }

    Node head;
    // private Node Node; // THis is used for the recursion reverse 

    public void createList(Integer data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
        }

        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " => ");
            currNode = currNode.next;

        }

        System.out.println("NULL");
    }

    public void reverseIterate() {

        if (head == null || head.next == null) {
            return;
        }

        // Achieved using 3 variables prevNode, currNode, and nextNode.
        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;

            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Reverse list = new Reverse();
       list.createList(1);
        list.createList(2);
        list.createList(3);
        list.createList(4);
        // LinkedList<Integer> list = new LinkedList<Integer>();
        list.printList();

        list.head = list.reverseRecursive(list.head);

        list.printList();
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.addFirst(1);

        // System.out.println(list);

        // list.reversed();

        // System.out.println(list.reversed());

    }

}
