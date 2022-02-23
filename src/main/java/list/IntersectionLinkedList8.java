package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList8 {

    // O(l + r) time | O(1) space
    public static ListNode getIntersectionNode(ListNode l, ListNode r) {
        if (l == null || r == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode c = l;
        while (c != null) {
            set.add(c);
            c = c.next;
        }

        c = r;
        while (c != null) {
            if (set.contains(c)) return c;
            c = c.next;
        }
        return null;
    }

    // O(l + r) time | O(1) space
    public static ListNode getIntersectionNode1(ListNode l, ListNode r) {
        if (l == null || r == null) return null;

        ListNode cl = l;
        ListNode cr = r;

        while (cl != cr) {
            cl = (cl != null) ? cl.next : r;
            cr = (cr != null) ? cr.next : l;
        }
        return cl;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1, common));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        System.out.println(getIntersectionNode(l1, l2));
        System.out.println(getIntersectionNode1(l1, l2));
    }
}
