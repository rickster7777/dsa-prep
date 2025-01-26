package linkedlist.RemoveNthNodeFromEndofList19;

class Solution {

    public class ListNode {
        ListNode next;
        ListNode(ListNode next){
            this.next = next;
        }
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        int size = 0;

        // calculating size of the list
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // if the node to remove from the end is same as the size of the list in that case
        if (n == size) {
            return head.next;
        }
        //instead of removing nth node if the value of the nth node is to be printed then instead of size -n => size -n +1 would've been used.
        int indexToSearch = size - n;
        ListNode prev = head;
        int i = 1;

        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
