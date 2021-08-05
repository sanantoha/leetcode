package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionLinkedList3 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }

        return currA;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode l1 = new ListNode(4, new ListNode(1, common));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        System.out.println(getIntersectionNode(l1, l2));
        System.out.println(getIntersectionNode1(l1, l2));
    }
}
