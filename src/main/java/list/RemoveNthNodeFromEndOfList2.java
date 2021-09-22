package list;

public class RemoveNthNodeFromEndOfList2 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
        ListNode fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            if (k > 0) {
                return head;
            } else {
                return head.next;
            }
        }

        ListNode slow = head;
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
