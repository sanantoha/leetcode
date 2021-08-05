package top.interview.question.medium.trees;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

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
        return root;
    }
}

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

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

        System.out.println(s.connect(root));
    }
}
