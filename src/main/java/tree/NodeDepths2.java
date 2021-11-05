package tree;

import java.util.Deque;
import java.util.LinkedList;

public class NodeDepths2 {

    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // O(n) time | O(h) space
    public static int nodeDepths(TreeNode root) {

        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        int sumOfDepth = 0;

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int depth = pair.depth;
            TreeNode curr = pair.node;

            if (curr == null) continue;

            sumOfDepth += depth;

            stack.push(new Pair(curr.left, depth + 1));
            stack.push(new Pair(curr.right, depth + 1));
        }

        return sumOfDepth;
    }

    // O(n) time | O(h) space
    public static int nodeDepthsRec(TreeNode root) {
        return nodeDepthsRec(root, 0);
    }

    private static int nodeDepthsRec(TreeNode root, int depth) {
        if (root == null) return 0;
        return depth + nodeDepthsRec(root.left, depth + 1) + nodeDepthsRec(root.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        System.out.println(nodeDepths(root) == 16);
        System.out.println(nodeDepthsRec(root) == 16);
    }
}
