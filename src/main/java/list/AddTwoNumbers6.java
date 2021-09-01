package list;

public class AddTwoNumbers6 {

    public static ListNode addTwoNumbers(ListNode headA, ListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        ListNode currA = headA;
        ListNode currB = headB;
        int carry = 0;

        while (currA != null || currB != null) {
            int valA = currA != null ? currA.val : 0;
            int valB = currB != null ? currB.val : 0;
            int sum = valA + valB + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
            if (currA != null) currA = currA.next;
            if (currB != null) currB = currB.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(0, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(7, new ListNode(3, new ListNode(2)));

        System.out.println(addTwoNumbers(l1, l2));
    }
}
