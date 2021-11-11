package list;

public class SortList6 {

    // O(n * log(n)) time | O(1) space
    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);

        ListNode l = sort(head);
        ListNode r = sort(mid);
        return merge(l, r);
    }

    private static ListNode getMiddle(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private static ListNode merge(ListNode l, ListNode r) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode currL = l;
        ListNode currR = r;

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

        curr.next =  (currL != null) ? currL : currR;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(9, new ListNode(3,
                new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(8))))));

        ListNode res = sort(lst);

        System.out.println(res);
    }
}
