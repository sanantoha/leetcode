package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerInEachNode3 {

    public static Node connect(Node node) {
        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prev = null;

            while (size-- > 0) {
                Node curr = queue.remove();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return node;
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
