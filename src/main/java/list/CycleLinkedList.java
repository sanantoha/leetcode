package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList {

    // O(n) time | O(n) space
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    // O(n) time | O(1) space
    public static boolean hasCycleWithoutExtraMemory(ListNode head) {

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

        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(hasCycle(lst));


        ListNode node3 = new ListNode(3, new ListNode(4, new ListNode(5)));
        ListNode cycleLst = new ListNode(1, new ListNode(2, node3));
        cycleLst.next.next.next.next = node3;

        System.out.println(hasCycle(cycleLst));

        System.out.println(hasCycleWithoutExtraMemory(lst));
        System.out.println(hasCycleWithoutExtraMemory(cycleLst));
    }
}
