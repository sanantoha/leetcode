package list;

import java.util.List;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int x = curr1 == null ? 0 : curr1.val;
            int y = curr2 == null ? 0 : curr2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(addTwoNumbers(l1, l2));

        ListNode l11 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l22 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        System.out.println(addTwoNumbers(l11, l22));
    }
}
