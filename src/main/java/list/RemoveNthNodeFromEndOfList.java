package list;

public class RemoveNthNodeFromEndOfList {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return null;

        ListNode curr = head;
        int k = n;

        while (k > 0 && curr != null) {
            k--;
            curr = curr.next;
        }

        if (k > 0) return head;
        if (curr == null) {
            if (k == 0) return head.next;
            return head;
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
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 1);

        System.out.println(res);
    }
}
