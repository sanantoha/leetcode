package list;

public class ReverseLinkedList4 {

    public static ListNode reverse(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));

        ListNode res = reverse(lst);
        System.out.println(res);
    }
}
