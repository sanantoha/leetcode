package list;

public class SortList7 {

    // O(n * log(n)) time | O(1) space
    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);
        return merge(left, right);
    }

    private static ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode currL = left;
        ListNode currR = right;

        while (currL != null && currR != null) {
            if (currL.val <= currR.val) {
                curr.next = currL;
                currL = currL.next;
            } else {
                curr.next = currR;
                currR = currR.next;
            }
            curr = curr.next;
        }

        curr.next = (currL != null) ? currL : currR;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(9, new ListNode(3,
                new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(8))))));

        ListNode res = sort(lst);

        System.out.println(res);
    }
}
