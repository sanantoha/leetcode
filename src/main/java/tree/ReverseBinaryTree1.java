package tree;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseBinaryTree1 {

    // O(n) time | O(h) space
    public static void reverse(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
    }

    // O(n) time | O(h) space
    public static void reverseIter(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == null) continue;

            TreeNode l = curr.left;
            TreeNode r = curr.right;
            curr.right = l;
            curr.left = r;
            stack.push(curr.left);
            stack.push(curr.right);
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
                                new TreeNode(14),
                                new TreeNode(17))));

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
                                new TreeNode(14),
                                new TreeNode(17))));

        System.out.println(root1);

        reverseIter(root1);

        System.out.println(root1);
    }
}
