package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeDepths4 {

    static class TreeInfo {
        TreeNode node;
        int depth;

        public TreeInfo(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // O(n) time | O(h) space
    public static int nodeDepths(TreeNode root) {

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));

        int sumOfDepths = 0;

        while (!queue.isEmpty()) {
            TreeInfo ti = queue.remove();
            int depth = ti.depth;
            TreeNode node = ti.node;
            if (node == null) continue;

            sumOfDepths += depth;

            queue.add(new TreeInfo(node.left, depth + 1));
            queue.add(new TreeInfo(node.right, depth + 1));
        }

        return sumOfDepths;
    }

    // O(n) time | O(h) space
    public static int nodeDepthsRec(TreeNode root) {
        return nodeDepthsRec(root, 0);
    }

    private static int nodeDepthsRec(TreeNode root, int depth) {
        if (root == null) return 0;
        return depth + nodeDepthsRec(root.left, depth + 1) + nodeDepthsRec(root.right, depth + 1);
    }

    /**
     *  Write function that takes in a Binary Tree and return the sum of its node's depths.
     *  https://www.algoexpert.io/questions/Node%20Depths
     *            1
     *          /   \
     *         2     3
     *       /  \  /  \
     *     4    5 6    7
     *   / \
     *  8   9
     */
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
