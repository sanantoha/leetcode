package top.interview.question.medium.list;

import java.util.List;

class Solution0 {

    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode res = new ListNode(-1);
        ListNode curRes = res;
        int prev = 0;

        while (curr1 != null || curr2 != null) {

            if (curr1 != null && curr2 != null) {
                int nv = curr1.val + curr2.val + prev;
                if (nv > 9) {
                    curRes.next = new ListNode(nv - 10);
                    prev = 1;
                } else {
                    curRes.next = new ListNode(nv);
                    prev = 0;
                }

                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1 != null) {
                int nv = curr1.val + prev;
                if (nv > 9) {
                    curRes.next = new ListNode(nv - 10);
                    prev = 1;
                } else {
                    curRes.next = new ListNode(nv);
                    prev = 0;
                }
                curr1 = curr1.next;
            } else {
                int nv = curr2.val + prev;
                if (nv > 9) {
                    curRes.next = new ListNode(nv - 10);
                    prev = 1;
                } else {
                    curRes.next = new ListNode(nv);
                    prev = 0;
                }
                curr2 = curr2.next;
            }


            curRes = curRes.next;
        }
        if (prev == 1) {
            curRes.next = new ListNode(1);
        }

        return res.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        ListNode l = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode r = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(s.addTwoNumbers(l, r));


        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode r2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        System.out.println(s.addTwoNumbers(l1, r2));
    }
}
