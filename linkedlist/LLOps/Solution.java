class ListNode {
    int val;
    ListNode next;

    // Constructors
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
