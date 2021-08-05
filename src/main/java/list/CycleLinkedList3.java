package list;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList3 {

    public static boolean isCycle(ListNode head) {
        if (head == null) return false;

        ListNode curr = head;
        Set<ListNode> set = new HashSet<>();

        while (curr != null) {
            if (set.contains(curr)) return true;
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public static boolean isCycleWS(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(3)));
        ListNode nxt = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, root))));
        root.next.next.next = nxt;

        ListNode root1 = new ListNode(0, new ListNode(1, new ListNode(2)));

        System.out.println(isCycle(root));
        System.out.println(isCycle(root1));

        System.out.println(isCycleWS(root));
        System.out.println(isCycleWS(root1));
    }
}
