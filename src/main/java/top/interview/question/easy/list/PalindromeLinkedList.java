package top.interview.question.easy.list;


class Solution4 {

    public ListNode rev(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode copy(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode newCur = dummy;
        while (cur != null) {
            newCur.next = new ListNode(cur.val);
            cur = cur.next;
            newCur = newCur.next;
        }
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode origin = copy(head);
        ListNode reverse  = rev(head);

        ListNode cur = origin;
        ListNode curRev = reverse;
        while (cur != null && curRev != null) {
            if (cur.val != curRev.val) return false;
            cur = cur.next;
            curRev = curRev.next;
        }
        return true;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        System.out.println(s.isPalindrome(lst));
    }
}
