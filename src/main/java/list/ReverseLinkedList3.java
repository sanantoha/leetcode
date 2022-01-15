package list;

public class ReverseLinkedList3 {

    // O(n) time | O(1) space
    public static ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
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
