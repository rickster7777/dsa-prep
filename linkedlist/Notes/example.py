#Insert at the beginning
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    # Insert a node at the beginning
    def insert_at_head(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    # Print the linked list
    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

# Create a Linked List and insert some elements
linked_list = LinkedList()
linked_list.insert_at_head(10)
linked_list.insert_at_head(20)
linked_list.insert_at_head(30)

linked_list.print_list()

# Output
# 30 -> 20 -> 10 -> None


#Insert at the end

class LinkedList:
    def __init__(self):
        self.head = None

    # Insert a node at the end
    def insert_at_end(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

# Create Linked List and insert at the end
linked_list = LinkedList()
linked_list.insert_at_end(10)
linked_list.insert_at_end(20)
linked_list.insert_at_end(30)

linked_list.print_list()

# Output
# 10 -> 20 -> 30 -> None


# This is just an introduction to linked lists. Would you like to explore more advanced topics like reversing a linked list, 
# deleting nodes, or implementing a doubly linked list? Let me know!