package list;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fst = dummy;
        ListNode snd = dummy;

        for (int i = 0; i <= n; i++) {
            fst = fst.next;
        }

        while (fst != null) {
            fst = fst.next;
            snd = snd.next;
        }

        snd.next = snd.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 2);

        System.out.println(res);
    }
}
