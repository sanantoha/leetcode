package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionLinkedList1 {

    public static ListNode getIntersectionNode(ListNode l, ListNode r) {
        return null;
    }

    public static ListNode getIntersectionNode1(ListNode l, ListNode r) {
        return null;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1, common));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        System.out.println(getIntersectionNode(l1, l2));
        System.out.println(getIntersectionNode1(l1, l2));
    }
}
