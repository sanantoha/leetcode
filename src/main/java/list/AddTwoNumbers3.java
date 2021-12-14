package list;

import java.util.List;

public class AddTwoNumbers3 {

    // O(max(l1, l2)) time | O(max(l1, l2)) space
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode c = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;

        int carry = 0;

        while (c1 != null || c2 != null) {
            int val1 = c1 == null ? 0 : c1.val;
            int val2 = c2 == null ? 0 : c2.val;
            int sum = val1 + val2 + carry;
            c.next = new ListNode(sum % 10);
            carry = sum / 10;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;

            c = c.next;
        }

        if (carry > 0) {
            c.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(9, new ListNode(9))));
        ListNode head2 = new ListNode(7, new ListNode(3, new ListNode(2)));

        System.out.println(merge(head1, head2));
    }
}
