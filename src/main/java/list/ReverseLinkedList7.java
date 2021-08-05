package list;

public class ReverseLinkedList7 {

    public static ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next; // 2
            curr.next = prev; // 1
            prev = curr; // 1
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(reverse(head));
    }
}
