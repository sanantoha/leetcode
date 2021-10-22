package list;

public class DeleteNodeInLinkedList2 {

    // O(n) time | O(1) space
    public static void deleteNode(ListNode node) {
        if (node == null) return;

        ListNode curr = node;

        while (curr != null) {

            ListNode next = curr.next;
            if (next != null) {
                curr.val = next.val;
                if (next.next == null) {
                    curr.next = null;
                }
            }

            curr = next;
        }
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3, new ListNode(4, new ListNode(5)));
        ListNode node1 = new ListNode(2, node0);
        ListNode lst = new ListNode(1, node1);

        deleteNode(node0);

        System.out.println(lst);
    }
}
