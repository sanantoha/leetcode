package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList {

    // O(n) time | O(n) space where l1 + l2 = n
    public static ListNode intersection(ListNode left, ListNode right) {
        if (left == null || right == null) return null;

        Set<ListNode> set = new HashSet<>();

        ListNode currL = left;
        while (currL != null) {
            set.add(currL);
            currL = currL.next;
        }

        ListNode currR = right;
        while (currR != null) {
            if (set.contains(currR)) return currR;
            currR = currR.next;
        }

        return null;
    }

    // O(n) time | O(1) space where l1 + l2 = n
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {

            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }

        return currA;
    }

    public static void main(String[] args) {

        ListNode inter = new ListNode(8, new ListNode(5, new ListNode(4)));

        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3, inter)));
        ListNode headB = new ListNode(9, new ListNode(10, new ListNode(11, new ListNode(12, inter))));

        System.out.println(getIntersectionNode(headA, headB));
        System.out.println(intersection(headA, headB));
    }
}