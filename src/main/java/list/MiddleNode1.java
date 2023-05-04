package list;

public class MiddleNode1 {

    public static ListNode middleNode(ListNode l) {
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(19))));

        // 15 19 null
        System.out.println(middleNode(head));

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // 3 4 5 null
        System.out.println(middleNode(head1));
    }
}
