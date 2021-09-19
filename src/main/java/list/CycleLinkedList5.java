package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList5 {

    public static boolean isCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (seen.contains(curr)) return true;
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static boolean isCycleWS(ListNode head) {
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
        root.next.next.next = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, root))));

        ListNode root1 = new ListNode(0, new ListNode(1, new ListNode(2)));

        System.out.println(isCycle(root));
        System.out.println(isCycle(root1));

        System.out.println(isCycleWS(root));
        System.out.println(isCycleWS(root1));
    }
}
