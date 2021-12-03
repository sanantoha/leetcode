package list;

public class RemoveNthNodeFromEndOfList5 {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return head;

        int k = n;
        ListNode curr = head;
        while (k > 0 && curr != null) {
            k--;
            curr = curr.next;
        }

        if (curr == null) {
            if (k == 0) {
                return head.next;
            } else {
                return head;
            }
        }

        ListNode fst = head;
        ListNode snd = curr;
        while (snd.next != null) {
            fst = fst.next;
            snd = snd.next;
        }

        ListNode next = fst.next;
        if (next != null) {
            fst.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 6);

        System.out.println(res);
    }
}
