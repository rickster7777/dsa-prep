
import java.util.Stack;

/*
Input:  l1 = [2,4,3]
        l2 = [5,6,4]
Output:        [7,0,8]
Explanation:   342 + 465 = 807

 */


class ListNode {
    int val;
    ListNode next;

    // Constructors
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    // Method to add two numbers represented by linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to build result
        ListNode current = dummyHead;
        int carry = 0;

        // Traverse both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Current digit from l1
            int val2 = (l2 != null) ? l2.val : 0; // Current digit from l2
            int sum = val1 + val2 + carry;

            carry = sum / 10; // Update carry
            current.next = new ListNode(sum % 10); // Create node with result digit
            current = current.next;

            // Move to next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Return head of result list
    }


    // below all the part is only to run in vscode
    // In leetCode only above addTwoNumbers func is to be provided.
    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
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
        ListNode l1 = buildList(new int[]{2, 4, 3});
        ListNode l2 = buildList(new int[]{5, 6, 4});

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.print("Result: ");
        printList(result);  // Expected: 7 -> 0 -> 8
    }
}




//using Stack this doesn't provide the original sol to prob it prints in the forward direction

class UsingStack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = (!stack1.isEmpty()) ? stack1.pop() : 0;
            int val2 = (!stack2.isEmpty()) ? stack2.pop() : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }
}
