package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSTreeTraverse1 {

    public static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(9,
                        new TreeNode(7),
                        new TreeNode(12,
                                new TreeNode(10),
                                new TreeNode(13)))
        );

        bfs(root);
    }
}
