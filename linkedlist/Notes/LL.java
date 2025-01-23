package linkedlist.Notes;

public class LL {

    Node head;
    private int size;

    LL(){
        this.size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            // initially, when the node is created it'll point to the null.
            this.next = null;
        }

    }

   
    // // Head of the list
    // private Node head;

    // // Constructor for Linked List
    // public LL() {
    // this.head = null; // Initialize head as null
    // }

    // Add node at first
    public void addFirst(String data) {
        Node newNode = new Node(data);

        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add node at first
    public void addLast(String data) {
        Node newNode = new Node(data);

        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        // initially, making the current node point to a head.
        Node currNode = head;

        // As long as nex node is not null currNode will be the next node.
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        // moment null is found newNode is updated to be the last node.
        currNode.next = newNode;

    }

    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
        }

        Node currNode = head;

        // currNode.next != null: .next doesn't let the last node to get printed.
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    // Delete operations.

    // To delete first node.
    // point the head towards the next node of head.

    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is emplty");
            return;
        }
        size--;
        head = head.next;
    }

    // To delete the last node.
    // point the second last node to null.

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is emplty");
            return;
        }

        size--;
        // for the case where there'll be only 1 node in the linked list.
        if (head.next == null) {
            head = null;
            return;
        }

        // For all the cases where there are multiple nodes in the LL.
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;

    }


    public int getSize(){
        return size;
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("This");
        list.printList();
        System.out.println(list.getSize());
        
        list.deleteFirst();
        list.printList();

        
        list.deleteLast();;
        list.printList();
        System.out.println(list.getSize());
    }
}
