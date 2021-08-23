package list;

public class PalindromeLinkedList1 {

    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode c1 = prev;
        ListNode c2 = slow;
        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) return false;
            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode lst1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

        System.out.println(isPalindrome(lst));
        System.out.println(isPalindrome(lst1));
    }
}
