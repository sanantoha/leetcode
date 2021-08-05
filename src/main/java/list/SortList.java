package list;

public class SortList {

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode l = sort(head);
        ListNode r = sort(mid);
        return merge(l, r);
    }

    private static ListNode getMid(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private static ListNode merge(ListNode l, ListNode r) {

        ListNode dummy = new ListNode();
        ListNode c = dummy;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                c.next = l;
                l = l.next;
            } else {
                c.next = r;
                r = r.next;
            }
            c = c.next;
        }

        c.next = (l != null) ? l : r;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(2))))));

        System.out.println(sort(lst));

        System.out.println(sort(new ListNode(1)));

        System.out.println(sort(new ListNode(7, new ListNode(4))));
    }
}
