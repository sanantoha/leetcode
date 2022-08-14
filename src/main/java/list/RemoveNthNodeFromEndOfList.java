package list;

public class RemoveNthNodeFromEndOfList {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fst = dummy;
        ListNode snd = dummy;
        int k = n;
        while (fst != null && k >= 0) {
            fst = fst.next;
            k--;
        }

        if (fst == null && k >= 0) return dummy.next;

        while (fst != null) {
            fst = fst.next;
            snd = snd.next;
        }

        if (snd.next != null) {
            snd.next = snd.next.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 0);

        System.out.println(res);
    }
}
