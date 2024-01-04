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
public class InsertGreatestCommonDivisors1 {

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        return null;
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
