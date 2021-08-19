package list;

public class SortList3 {

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode l = sort(head);
        ListNode r = sort(mid);
        return merge(l, r);
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode cl = l;
        ListNode cr = r;
        ListNode dummy = new ListNode();
        ListNode c = dummy;
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

        c.next = (cl != null) ? cl : cr;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(9, new ListNode(3,
                new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(8))))));

        ListNode res = sort(lst);

        System.out.println(res);
    }
}
