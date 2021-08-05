package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList1 {

    public static boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static boolean hasCycleWithoutMemory(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(hasCycle(head));
        System.out.println(hasCycleWithoutMemory(head));



        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        head1.next.next = new ListNode(4, new ListNode(5, new ListNode(6, head1)));

        System.out.println(hasCycle(head1));
        System.out.println(hasCycleWithoutMemory(head1));
    }
}
