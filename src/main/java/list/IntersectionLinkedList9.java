package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList9 {

    // O(n) time | O(n) space
    public static ListNode getIntersectionNode(ListNode l, ListNode r) {
        if (l == null || r == null) return null;

        Set<ListNode> seen = new HashSet<>();

        ListNode curr = l;
        while (curr != null) {
            seen.add(curr);
            curr = curr.next;
        }

        ListNode snd = r;
        while (snd != null) {
            if (seen.contains(snd)) return snd;
            snd = snd.next;
        }

        return null;
    }

    // O(n) time | O(1) space
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
