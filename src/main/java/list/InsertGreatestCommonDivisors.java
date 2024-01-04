package list;

/**
 * Given the head of a linked list head, in which each node contains an integer value.
 *
 * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common
 * divisor of them.
 *
 * Return the linked list after insertion.
 *
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides
 * both numbers.
 */
public class InsertGreatestCommonDivisors {

    // O(n * log(k)) time | O(1) space -
    // because GCD complexity is log of sum two values then k is max sum in two numbers
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        while (curr.next != null) {
           int gcd = gcd(curr.val, curr.next.val);
           ListNode node = new ListNode(gcd);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }

        return head;
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(18, new ListNode(6,  new ListNode(10, new ListNode(3))));
        // 18 -> 6 -> 10 -> 3 -> null
        System.out.println(lst);

        ListNode res = insertGreatestCommonDivisors(lst);

        // 18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3 -> null
        System.out.println(res);
    }

}
