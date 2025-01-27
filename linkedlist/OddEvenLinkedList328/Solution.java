package linkedlist.OddEvenLinkedList328;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into odd and even lists
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;  // link odd nodes
            even.next = even.next.next; // link even nodes

            odd = odd.next;  // move odd pointer
            even = even.next;  // move even pointer
        }

        // Combine odd and even lists
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input: [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = solution.oddEvenList(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}



//My Approach
// public ListNode oddEvenList(ListNode head) {
//     if (head == null && head.next == null) {
//         return head;
//     }

//     int size = 0;
//     ListNode currt = head;
//     while (currt != null) {
//         currt = currt.next;
//         size++;
//     }

//     ListNode curr = head;
//     for (int i = 1; i <= size; i++) {
//         ListNode firstEvenNode; 
//         if (i == 2) {
//             firstEvenNode = curr;
//         }

//         if (curr.next != null && curr.next.next != null) {
//             curr.next = curr.next.next;
//         }
//         if (curr.next == null) {
//             curr.next = firstEvenNode;
//         }
//         if (curr.next.next == null) {
//             curr.next = null;
//         }
//         curr = curr.next;
//     }
//     return head;
// }