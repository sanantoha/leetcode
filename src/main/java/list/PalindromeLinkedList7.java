package list;

public class PalindromeLinkedList7 {

    // O(n) time | O(1) space
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode fst = head;
        ListNode snd = reverse(slow);

        while (snd != null) {
            if (snd.val != fst.val) return false;
            snd = snd.next;
            fst = fst.next;
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
    }
}
