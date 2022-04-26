package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerInEachNode3 {

    // O(n) time | O(n) space
    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;

            while (size-- > 0) {
                Node node = queue.remove();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5),
                        null),
                new Node(3,
                        new Node(6),
                        new Node(7),
                        null),
                null
        );

        System.out.println(connect(root));

        System.out.println(root);
    }
}
