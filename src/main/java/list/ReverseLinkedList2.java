package list;

import java.util.List;

public class ReverseLinkedList2 {

    public static ListNode rev(ListNode root) {
        if (root == null) return null;

        ListNode curr = root;
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println(rev(root));
    }
}
