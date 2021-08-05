package top.interview.question.medium.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {

    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode currA = headA;
        ListNode currB = headB;

        Set<ListNode> set = new HashSet<>();

        while (currA != null || currB != null) {

            if (currA == currB) {
                return currA;
            } else if (set.contains(currA)) {
                return currA;
            } else if (set.contains(currB)) {
                return currB;
            }

            if (currA != null) {
                set.add(currA);
                currA = currA.next;
            }
            if (currB != null) {
                set.add(currB);
                currB = currB.next;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {

            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;

        }

        return currA;
    }
}

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        ListNode inter = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA = new ListNode(4, new ListNode(1, inter));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, inter)));

        System.out.println(s.getIntersectionNode(headA, headB));


        ListNode inter1 = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA1 = new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(6,
                new ListNode(9, new ListNode(9, new ListNode(10, inter1)))))));

        System.out.println(s.getIntersectionNode(headA1, inter1));


        ListNode headA2 = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode headB2 = new ListNode(1, new ListNode(5));

        System.out.println(s.getIntersectionNode(headA2, headB2));
    }
}
