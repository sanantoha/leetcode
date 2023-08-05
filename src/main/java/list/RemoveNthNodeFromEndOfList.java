package list;

public class RemoveNthNodeFromEndOfList {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode curr = head;
        int k = n - 1;
        while (curr != null && k >= 0) {
            curr = curr.next;
            k--;
        }

        if (curr == null) {
            if (k < 0) return head.next;
            else return head;
        }

        curr = curr.next;
        ListNode snd = head;
        while (curr != null) {
            curr = curr.next;
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

        ListNode res = removeNthFromEnd(lst, 0);

        System.out.println(res);
    }
}
