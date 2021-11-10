package list;

public class RemoveNthNodeFromEndOfList4 {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return head;

        ListNode curr = head;

        while (curr != null && n > 0) {
            curr = curr.next;
            n--;
        }

        if (curr == null) {
            if (n > 0) return head;
            return head.next;
        }

        ListNode fst = curr;
        ListNode snd = head;

        while (fst.next != null) {
            fst = fst.next;
            snd = snd.next;
        }

        ListNode next = snd.next;
        if (next != null) {
            snd.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode res = removeNthFromEnd(lst, 4);

        System.out.println(res);
    }
}
