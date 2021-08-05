package top.interview.question.easy.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution5 {

    public boolean hasCycle0(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        ListNode root = new ListNode(3, new ListNode(2));
        ListNode node2 = root.next;
        root.next.next = new ListNode(0, new ListNode(4, node2));

        System.out.println(s.hasCycle(root));

        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(s.hasCycle(root1));
    }
}
