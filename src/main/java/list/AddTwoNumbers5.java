package list;

public class AddTwoNumbers5 {

    // O(max(l1, l2)) time | O(max(l1, l2)) space
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode c = dummy;
        int carry = 0;

        while (c1 != null || c2 != null) {
            int val1 = c1 != null ? c1.val : 0;
            int val2 = c2 != null ? c2.val : 0;
            int sum = val1 + val2 + carry;
            c.next = new ListNode(sum % 10);
            c = c.next;
            carry = sum / 10;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }

        if (carry > 0) {
            c.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(0, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(7, new ListNode(3, new ListNode(2)));

        System.out.println(addTwoNumbers(l1, l2));
    }
}
