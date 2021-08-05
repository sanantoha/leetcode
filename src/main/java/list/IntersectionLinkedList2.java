package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList2 {

    public static ListNode intersection(ListNode left, ListNode right) {
        if (left == null || right == null) return null;

        ListNode currL = left;
        ListNode currR = right;

        Set<ListNode> set = new HashSet<>();

        while (currL != null) {
            set.add(currL);
            currL = currL.next;
        }

        while (currR != null) {
            if (set.contains(currR)) return currR;
            currR = currR.next;
        }

        return null;
    }

    public static ListNode intersectionWS(ListNode left, ListNode right) {
        if (left == null || right == null) return null;

        ListNode currL = left;
        ListNode currR = right;

        while (currL != currR) {
            currL = currL == null ? left : currL.next;
            currR = currR == null ? right : currR.next;
        }
        return currL;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))));
        ListNode lst1 = new ListNode(0, new ListNode(1, new ListNode(2, common)));
        ListNode lst2 = new ListNode(-5, new ListNode(-4, common));

        System.out.println(intersection(lst1, lst2));
        System.out.println(intersectionWS(lst1, lst2));
    }
}
