package list;

public class MergedTwoSortedLists2 {

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode c = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null || c2 != null) {
            if (c1 != null && c2 != null) {
                if (c1.val <= c2.val) {
                    c.next = new ListNode(c1.val);
                    c1 = c1.next;
                } else {
                    c.next = new ListNode(c2.val);
                    c2 = c2.next;
                }
            } else if (c1 != null) {
                c.next = new ListNode(c1.val);
                c1 = c1.next;
            } else {
                c.next = new ListNode(c2.val);
                c2 = c2.next;
            }

            c = c.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(19))));
        ListNode l2 = new ListNode(7, new ListNode(9, new ListNode(10, new ListNode(16))));

        System.out.println(merge(l1, l2));
    }
}
