package list;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList2 {

    public static boolean isCycle(ListNode root) {
        if (root == null) return false;

        Set<ListNode> set = new HashSet<>();

        ListNode curr = root;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public static boolean isCycleWithoutSpace(ListNode root) {
        if (root == null) return false;


        ListNode slow = root;
        ListNode fast = root.next;

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

        System.out.println(isCycleWithoutSpace(root));
        System.out.println(isCycleWithoutSpace(root1));
    }
}
