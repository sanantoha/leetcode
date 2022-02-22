package list;

public class RemoveNthNodeFromEndOfList6 {

    // O(n) time | O(1) space
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode curr = head;
        while (curr != null && n >= 0) {
            curr = curr.next;
            n--;
        }

        if (curr == null) {
            if (n == 0) {
                return head.next;
            }
            return head;
        }

        ListNode snd = head;

        while (curr != null) {
            curr = curr.next;
            snd = snd.next;
        }

        if (snd.next != null) {
            snd.next = snd.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 1);

        System.out.println(res);
    }
}
