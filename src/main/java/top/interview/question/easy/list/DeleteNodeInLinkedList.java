package top.interview.question.easy.list;

class Solution0 {
    public void deleteNode(ListNode node) {
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            if (next != null) {
                cur.val = next.val;
                if (next.next == null) {
                    cur.next = null;
                    break;
                }
            }

            cur = next;
        }
    }
}

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        s.deleteNode(root.next);

        System.out.println(root);
    }
}
