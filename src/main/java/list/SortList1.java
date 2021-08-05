package list;

public class SortList1 {

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
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;
        ListNode cl = l;
        ListNode cr = r;
        while (cl != null && cr != null) {
            if (cl.val <= cr.val) {
                c.next = cl;
                cl = cl.next;
            } else {
                c.next = cr;
                cr = cr.next;
            }
            c = c.next;
        }
        c.next = (cl == null) ? cr : cl;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9, new ListNode(2, new ListNode(7,
                new ListNode(4, new ListNode(1, new ListNode(3, new ListNode(17)))))));

        ListNode sorted = sort(head);

        System.out.println(sorted);
    }
}
