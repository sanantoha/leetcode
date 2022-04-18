package list;

public class RemoveNthNodeFromEndOfList7 {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (n < 0) return head;

        int k = n;
        ListNode curr = head;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        if (curr == null) {
            if (k == 0) return head.next;
            return head;
        }

        ListNode fst = curr;
        ListNode snd = head;

        while (fst.next != null) {
            snd = snd.next;
            fst = fst.next;
        }

        ListNode next = snd.next;
        if (next != null) {
            snd.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 4);

        System.out.println(res);
    }
}
