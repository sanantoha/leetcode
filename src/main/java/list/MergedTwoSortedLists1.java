package list;

public class MergedTwoSortedLists1 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(19))));
        ListNode head2 = new ListNode(7, new ListNode(9, new ListNode(10, new ListNode(16))));

        System.out.println(mergeTwoLists(head1, head2));
    }
}
