package top.interview.question.easy.list;

class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode curL = l1;
        ListNode curR = l2;

        ListNode cur = dummy;

        while (curL != null && curR != null) {
            if (curL.val <= curR.val) {
                cur.next = new ListNode(curL.val);
                curL = curL.next;
            } else {
                cur.next = new ListNode(curR.val);
                curR = curR.next;
            }
            cur = cur.next;
        }

        while (curL != null) {
            cur.next = new ListNode(curL.val);
            curL = curL.next;
            cur = cur.next;
        }

        while(curR != null) {
            cur.next = new ListNode(curR.val);
            curR = curR.next;
            cur = cur.next;
        }


        return dummy.next;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(s.mergeTwoLists(l1, l2));
    }
}
