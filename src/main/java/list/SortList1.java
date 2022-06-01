package list;

public class SortList1 {

    public static ListNode sort(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(9, new ListNode(3,
                new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(8))))));

        ListNode res = sort(lst);

        System.out.println(res);
    }
}
