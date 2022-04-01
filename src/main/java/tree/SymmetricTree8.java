package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree8 {

    // O(n) time | O(n) space
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.remove();
            TreeNode curr2 = queue.remove();

            if (curr1 == null && curr2 == null) continue;
            if (curr1 == null || curr2 == null) return false;
            if (curr1.val != curr2.val) return false;

            queue.add(curr1.left);
            queue.add(curr2.right);
            queue.add(curr1.right);
            queue.add(curr2.left);
        }
        return true;
    }

    // O(n) time | O(h) space
    public static boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;
        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetricRec(root));

        System.out.println("==================================");

        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                )
        );

        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetricRec(root1));

        System.out.println("==================================");

        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        System.out.println(isSymmetric(root2));
        System.out.println(isSymmetricRec(root2));
    }
}
