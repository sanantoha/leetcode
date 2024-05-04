package list;

public class OddEvenLinkedList1 {

    public static ListNode oddEvenList(ListNode head) {
        return null;
    }

    public static ListNode oddEvenList1(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode lst1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(oddEvenList(lst));
        System.out.println(oddEvenList1(lst1));


        ListNode lst2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode lst3 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));

        System.out.println(oddEvenList(lst2));
        System.out.println(oddEvenList1(lst3));
    }
}
