package list;

public class ReverseLinkedList8 {

    public static ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = reverse(lst);
        System.out.println(res);
    }
}
