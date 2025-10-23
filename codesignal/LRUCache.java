/*
 ✅ What is an LRU Cache?

An LRU Cache is a data structure that:
Stores key-value pairs (like a Map).
Has a fixed capacity.
When it reaches capacity and a new item is added:

It removes the least recently used item to make space.

✨ Requirements:
O(1) time for:
get(key): return the value if the key exists, otherwise -1.
put(key, value): insert or update the key-value pair.

🧠 Core Idea:

To achieve O(1) time for both operations, we combine two data structures:

1. HashMap:
Stores key → Node (for fast access).
Keys are stored along with a reference to the node in a linked list.

2. Doubly Linked List:
Maintains the order of usage.
Most recently used → Front of the list.
Least recently used → End of the list.
Allows O(1) removal and addition.

📌 Operations:
🔹 get(key)

If key exists:

Move its node to the front (because it’s recently used).

Return its value.

Else, return -1.

🔹 put(key, value)

If key exists:

Update value.

Move node to front.

Else:

If at capacity:

Remove tail node (least recently used).

Insert new node at the front.
 */

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail nodes to simplify insert/remove
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // Move accessed node to the front
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move to front
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToFront(node);
        } else {
            if (map.size() == capacity) {
                // Remove least recently used (tail.prev)
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            // Insert new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToFront(newNode);
        }
    }

    // Remove node from the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node right after head
    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/*
 | Approach                          | Maintains Order? | O(1) Get? | O(1) Put?              | Evict LRU in O(1)?            |
| --------------------------------- | ---------------- | --------- | ---------------------- | ----------------------------- |
| HashMap only                      | ❌ No             | ✅ Yes     | ✅ Yes                  | ❌ No (need to search for LRU) |
| HashMap + Queue (e.g. LinkedList) | ✅ Yes            | ✅ Yes     | ❌ No (removal is O(n)) | ✅ Yes                         |
| HashMap + Doubly Linked List ✅    | ✅ Yes            | ✅ Yes     | ✅ Yes                  | ✅ Yes                         |


✅ Why Doubly Linked List?

A doubly linked list allows:

Removing any node in O(1) time (because you store direct references).

Adding to the front (most recently used) in O(1).

Removing from the end (least recently used) in O(1).

This is why we pair HashMap with Doubly Linked List.

🔄 Alternative: Use LinkedHashMap in Java


in a easiest way possible explain me how data is stored in here in hashmap and DLL key to identify then how data will be stored in nodes becauses there can be n number of nodes

cache.put(1, 100);
cache.put(2, 200);
🔹 HashMap:
Key	Points to Node with
1	key=1, value=100
2	key=2, value=200

🔹 Doubly Linked List:

HEAD <-> [2:200] <-> [1:100] <-> TAIL

show diagram so this means number of nodes and keys will be same
✅ Answer to Your Question:

Will the number of keys and nodes always be the same?

Yes — for an LRU Cache:

Each key in the HashMap maps to one node

That node is also in the doubly linked list

So:

If you have n items in the cache

You will have n keys in the map

And n nodes in the list

and each key will have same set of complete nodes ?
🚫 Short Answer: No

Each key in the HashMap points to only one node — its own node — in the doubly linked list.
There is only one shared doubly linked list for the entire cache, and all keys share it.

✅ Here's What Really Happens:
✔️ One Key → One Node

Key 1 maps to → Node [1:A]

Key 2 maps to → Node [2:B]

etc.
Each key knows:

Its own node in the list

Not the whole list

✔️ One Shared Doubly Linked List

All nodes (for all keys) live inside the same linked list

List order = usage order

🔹 HashMap:
Key	Points to Node
1	Node [1:A]
2	Node [2:B]
3	Node [3:C]

Each key → only its own node.

🔹 Doubly Linked List (shared):
HEAD <-> [3:C] <-> [2:B] <-> [1:A] <-> TAIL


[3:C] = most recently used

[1:A] = least recently used

This list is shared — it's not duplicated per key.

✅ Final Conclusion
Statement	True/False
Each key has its own full set of nodes (full list)	❌ False
Each key maps to one node (its own)	✅ True
All nodes are part of one shared doubly linked list	✅ True
🧠 Think of it like this:

HashMap = Index

Node = Book Page

Linked List = Shelf in order of most to least recently used

There’s only one shelf, not one per book
 */

