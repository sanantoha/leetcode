package top.interview.question.hard.list;


import java.util.List;

public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private static ListNode getMid(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = (left != null) ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5)))));

        System.out.println(sortList(lst));
    }
}
