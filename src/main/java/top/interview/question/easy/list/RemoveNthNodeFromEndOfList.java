package top.interview.question.easy.list;

class Solution1 {

    public ListNode removeNthFromEnd0(ListNode head, int n) {
        if (head == null) return null;

        int sz = size(head);
        if (n > sz || (sz == n && n == 1)) return null;
        int k = sz - n - 1;


        ListNode cur = head;
        while(cur != null) {
            if (k <= 0) {
                if (cur.next != null) {
                    cur.next = cur.next.next;
                } else {
                    cur.next = null;
                }
                return head;
            }
            cur = cur.next;
            k--;
        }

        return head;
    }

    public int size(ListNode head) {
        int n = 0;
        ListNode cur = head;

        while(cur != null) {
            cur = cur.next;
            n++;
        }

        return n;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = size(head);
        int k = sz - n;


        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while(k > 0) {
            cur = cur.next;
            k--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        ListNode root = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(s.size(root));

        System.out.println(s.removeNthFromEnd(root, 2));
    }
}
