package list;

public class RemoveNthNodeFromEndOfList5 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode res = removeNthFromEnd(lst, 1);

        System.out.println(res);
    }
}
