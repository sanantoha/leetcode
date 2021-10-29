package list;

public class AddTwoNumbers9 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(0, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(7, new ListNode(3, new ListNode(2)));

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
