package list;

public class PalindromeLinkedList {

    // O(n) time | O(1) space
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;
        ListNode next = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.val != slow.val) return false;

            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    // O(n) time | O(1) space
    public static boolean isPalindrome1(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode fst = head;
        ListNode snd = reverse(slow);
        while (snd != null) {
            if (fst.val != snd.val) return false;
            fst = fst.next;
            snd = snd.next;
        }


        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        ListNode lst1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

        System.out.println(isPalindrome(lst));
        System.out.println(isPalindrome(lst1));


        System.out.println(isPalindrome1(lst));
        System.out.println(isPalindrome1(lst1));
    }
}
