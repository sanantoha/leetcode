package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList1 {

    public static boolean isCycle(ListNode head) {
        return false;
    }

    public static boolean isCycleWS(ListNode head) {
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(3)));
        root.next.next.next = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, root))));

        ListNode root1 = new ListNode(0, new ListNode(1, new ListNode(2)));

        System.out.println(isCycle(root));
        System.out.println(isCycle(root1));

        System.out.println(isCycleWS(root));
        System.out.println(isCycleWS(root1));
    }
}
