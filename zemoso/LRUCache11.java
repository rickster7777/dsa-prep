/*
🔧 Key Data Structures:

HashMap
Maps keys to nodes.
Allows O(1) access to any node.
Doubly Linked List
Keeps track of the usage order.
Allows O(1) insertion and removal of nodes from both ends.

💡 Strategy:
Most recently used items go to the front of the list.
Least recently used items are removed from the end.

On get(key):
If key exists → move the node to the front → return value.
On put(key, value):
If key exists → update value, move to front.
Else → create new node, add to front.
If cache exceeds capacity → remove node at tail.
 */

import java.util.HashMap;

public class LRUCache11 {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail; // dummy head and tail

    public LRUCache11(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // GET: return value if key exists, else -1
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    // PUT: insert or update the key-value pair
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (cache.size() == capacity) {
                // Remove least recently used node
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    // Helper: move node to front
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    // Helper: add node right after head
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Helper: remove node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache11 cache = new LRUCache11(2); // capacity = 2

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // returns 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2));   // returns -1 (not found)

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1));   // returns -1
        System.out.println(cache.get(3));   // returns 3
        System.out.println(cache.get(4));   // returns 4
    }
}
