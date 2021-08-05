package top.interview.question.easy.list;

class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(s.reverseList(root));
    }
}
