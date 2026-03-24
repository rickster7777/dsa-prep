class ListNode {
    int val;
    ListNode next;

    // Constructors
    ListNode() {
        //Creates an empty node val defaults to 0, and next defaults to null.
    }

    ListNode(int val) {
        // Creates a node with a given value next is still null.
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        // Creates a node with: a value a link to another node
        this.val = val;
        this.next = next;
    }
    // 👉 int val and ListNode next are called parameters.
}
/*
🔁 Simple way to remember
Parameters = variables in definition
Arguments = values in call
*/
public class Solution {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper method to create a linked list from an array
    public static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = buildList(new int[] { 2, 4, 3 });
        ListNode l2 = buildList(new int[] { 5, 6, 4 });

        // Add the two numbers
        //ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.print("Result: ");
        printList(result); // Expected: 7 -> 0 -> 8
    }
}
