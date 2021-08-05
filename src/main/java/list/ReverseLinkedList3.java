package list;

public class ReverseLinkedList3 {

    public static ListNode reverse(ListNode head) {
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
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));

        System.out.println(reverse(root));
    }
}
