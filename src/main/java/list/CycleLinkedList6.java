package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList6 {

    // O(n) time | O(n) space
    public static boolean isCycle(ListNode head) {
        if (head == null) return false;

        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) return true;
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    // O(n) time | O(1) space
    public static boolean isCycleWS(ListNode head) {
        if (head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

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
