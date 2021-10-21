package list;

public class RemoveNthNodeFromEndOfList3 {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode curr = head;
        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }
        if (curr == null) {
            if (n > 0) return head;
            else return head.next;
        }

        ListNode slow = head;
        ListNode fast = curr;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode next = slow.next;
        if (next != null) {
            slow.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 1);

        System.out.println(res);
    }
}
