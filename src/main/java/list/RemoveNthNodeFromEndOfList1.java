package list;

public class RemoveNthNodeFromEndOfList1 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(lst);

        ListNode res = removeNthFromEnd(lst, 3);

        System.out.println(res);
    }
}
