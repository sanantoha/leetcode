package list;

public class MergedTwoSortedLists {

    // O(l1 + l2) time | O(1) space
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode();
        ListNode c = dummy;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                c.next = c1;
                c1 = c1.next;
            } else {
                c.next = c2;
                c2 = c2.next;
            }
            c = c.next;
        }

        c.next = (c1 != null) ? c1 : c2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(19))));
        ListNode head2 = new ListNode(7, new ListNode(9, new ListNode(10, new ListNode(16))));

        System.out.println(mergeTwoLists(head1, head2));
    }
}
