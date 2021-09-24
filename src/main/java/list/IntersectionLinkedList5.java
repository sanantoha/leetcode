package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList5 {

    // O(n) time | O(l1) space - where l1 + l2 = n
    public static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        Set<ListNode> seen = new HashSet<>();
        ListNode c1 = l1;
        while (c1 != null) {
            seen.add(c1);
            c1 = c1.next;
        }

        ListNode c2 = l2;
        while (c2 != null) {
            if (seen.contains(c2)) {
                return c2;
            }
            c2 = c2.next;
        }
        return null;
    }

    // O(n) time | O(1) space where l1 + l2 = n
    public static ListNode getIntersectionNode1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != c2) {
            c1 = (c1 == null) ? l2 : c1.next;
            c2 = (c2 == null) ? l1 : c2.next;
        }
        return c1;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1, common));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        System.out.println(getIntersectionNode(l1, l2));
        System.out.println(getIntersectionNode1(l1, l2));
    }
}
