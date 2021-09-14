package list;

public class ReverseLinkedList11 {

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));

        ListNode res = reverse(lst);
        System.out.println(res);
    }
}
