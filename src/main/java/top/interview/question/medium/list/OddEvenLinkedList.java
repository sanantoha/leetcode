package top.interview.question.medium.list;

class Solution1 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode currOdd = odd;
        ListNode currEven = even;

        ListNode node = head;
        int index = 1;
        while (node != null) {

            if (index % 2 == 0) {
                currEven.next = new ListNode(node.val);
                currEven = currEven.next;
            } else {
                currOdd.next = new ListNode(node.val);
                currOdd = currOdd.next;
            }
            index++;

            node = node.next;
        }

        currOdd.next = even.next;

        return odd.next;
    }
}

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(s.oddEvenList(lst));

        ListNode lst1 = new ListNode(2, new ListNode(1, new ListNode(3,
                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));

        System.out.println(s.oddEvenList(lst1));
    }
}
