package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBinaryTree {

    // O(n) time | O(n) space
    public static void reverse(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
    }

    // O(n) time | O(n) space
    public static void reverseIter(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr == null) continue;

            TreeNode l = curr.left;
            TreeNode r = curr.right;
            curr.left = r;
            curr.right = l;

            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(13),
                                new TreeNode(20))));

        System.out.println(root);

        reverse(root);

        System.out.println(root);

        System.out.println("==============================================");

        TreeNode root1 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(13),
                                new TreeNode(20))));

        System.out.println(root1);

        reverseIter(root1);

        System.out.println(root1);
    }
}
