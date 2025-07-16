package linkedlist.DeletetheMiddleNodeofaLinkedList2095;

//my Approach
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         if (head == null) {
//             return null;
//         }

//         int size = 0;
//         ListNode curr = head;

//         while (curr != null) {
//             curr = curr.next;
//             size++;
//         }

//         float indexToSearch = (float) Math.floor(size / 2.0);

//         for (int i = 0; i < indexToSearch; i++) {
//             ListNode prev = head;
//             ListNode next = head.next;
//             head = head.next;

//             if (i == indexToSearch - 1) {
//                 prev = head.next;
//                 return head;
//             }
//         }
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    // THs is already created by leetcode bts.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // This is the only main logic that needs to be added
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If there is only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize two pointers: slow and fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // Previous node to slow pointer (used to remove the middle node)

        // Traverse the list to find the middle node
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            prev = slow; // Update previous node to slow pointer
            slow = slow.next; // Move slow pointer one step
        }

        // Now 'slow' is at the middle node, and 'prev' is the node before it
        prev.next = slow.next; // Skip the middle node by linking previous node to next node

        return head; // Return the modified list
    }
}

// This main class and functin is only for the vscode to run this program
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Solution.ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Call deleteMiddle
        Solution.ListNode updatedHead = solution.deleteMiddle(head);

        System.out.println("After Deleting Middle Node:");
        printList(updatedHead);
    }

    // Helper method to print the linked list
    public static void printList(Solution.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
