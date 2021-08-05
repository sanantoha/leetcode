package list;

import java.util.List;

public class ReverseLinkedList5 {

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next; // 3
            curr.next = prev; // 1
            prev = curr; // 2
            curr = next; // 3
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(reverse(lst));
    }
}
