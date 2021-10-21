package list;

import java.util.List;

public class RemoveNthNodeFromEndOfList1 {

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        int n = k;
        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null && n >= 0) return dummy.next;

        ListNode slow = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 3);

        System.out.println(res);
    }
}
