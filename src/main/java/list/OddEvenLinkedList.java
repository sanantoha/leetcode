package list;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode evenDummy = new ListNode();
        ListNode oddDummy = new ListNode();
        ListNode even = evenDummy;
        ListNode odd = oddDummy;

        int i = 1;
        while (curr != null) {
            if (i++ % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }

        even.next = null;

        odd.next = evenDummy.next;

        return oddDummy.next;
    }

    public static ListNode oddEvenList1(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
