package list;

import java.util.List;

public class AddTwoNumbers1 {

    // O(max(l1, l2)) time | O(max(l1, l2)) space
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

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

            c = c.next;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }

        if (carry > 0) {
            c.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(9, new ListNode(9))));
        ListNode head2 = new ListNode(7, new ListNode(3, new ListNode(2)));

        System.out.println(addTwoNumbers(head1, head2));
    }
}
