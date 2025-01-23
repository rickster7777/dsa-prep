//Iteratively
// ListNode class to represent each node in the linked list
class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

// Function to reverse the linked list iteratively
function reverseList(head) {
    let prev = null;
    let curr = head;

    while (curr !== null) {
        let next = curr.next;  // Store the next node
        curr.next = prev;      // Reverse the current node's pointer
        prev = curr;           // Move prev one step forward
        curr = next;           // Move curr one step forward
    }

    return prev;  // prev is the new head of the reversed list
}

// Helper function to create a linked list from an array
function createLinkedList(arr) {
    let head = null;
    let current = null;

    for (let val of arr) {
        let newNode = new ListNode(val);
        if (head === null) {
            head = newNode;  // Initialize head
        } else {
            current.next = newNode;  // Link the previous node to the new one
        }
        current = newNode;  // Move to the next node
    }

    return head;
}

// Test the reverseList function
const arr = [1, 2, 3, 4, 5];
const head = createLinkedList(arr);  // Create the linked list from the array

// Reverse the linked list
const reversedHead = reverseList(head);

// Print the reversed linked list
let current = reversedHead;
const result = [];
while (current !== null) {
    result.push(current.val);
    current = current.next;
}
console.log(result);  // Output: [5, 4, 3, 2, 1]



// recursion
function reverseList(head) {
    // Base case: if the list is empty or contains only one node
    if (head === null || head.next === null) {
        return head;
    }
    
    // Recursive case: reverse the rest of the list
    let reversedList = reverseList(head.next);
    
    // Adjust the pointers
    head.next.next = head;
    head.next = null;
    
    return reversedList;  // This will be the new head of the reversed list
}
