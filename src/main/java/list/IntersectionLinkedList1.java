package list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList1 {

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

    public static ListNode intersectionWS(ListNode left, ListNode right) {
        if (left == null || right == null) return null;

        ListNode currL = left;
        ListNode currR = right;

        while (currL != currR) {
            currL = (currL == null) ? right : currL.next;
            currR = (currR == null) ? left : currR.next;
        }
        return currL;
    }

    public static void main(String[] args) {

        ListNode inter = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode rootL = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, inter))));
        ListNode rootR = new ListNode(-2, new ListNode(-1, new ListNode(0, inter)));

        ListNode rootR1 = new ListNode(100, new ListNode(200));


        System.out.println(intersection(rootL, rootR));
        System.out.println(intersection(rootL, rootR1));

        System.out.println(intersectionWS(rootL, rootR));
        System.out.println(intersectionWS(rootL, rootR1));
    }
}
