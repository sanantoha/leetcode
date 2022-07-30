package list;

public class MergedTwoSortedLists {

    // O(l1 + l2) time | O(l1 + l2) space
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();

        ListNode currL = l1;
        ListNode currR = l2;
        ListNode curr = dummy;

        while (currL != null && currR != null) {
            if (currL.val <= currR.val) {
                curr.next = new ListNode(currL.val);
                currL = currL.next;
            } else {
                curr.next = new ListNode(currR.val);
                currR = currR.next;
            }
            curr = curr.next;
        }

        while (currL != null) {
            curr.next = new ListNode(currL.val);
            curr = curr.next;
            currL = currL.next;
        }

        while (currR != null) {
            curr.next = new ListNode(currR.val);
            curr = curr.next;
            currR = currR.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode res = merge(l1, l2);
        System.out.println(res);
    }
}
