package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree6 {

    // O(n) time | O(h) space
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode l = queue.remove();
            TreeNode r = queue.remove();

            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;

            queue.add(l.left);
            queue.add(r.right);

            queue.add(l.right);
            queue.add(r.left);
        }
        return true;
    }

    // O(n) time | O(h) space
    public static boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;
        return areSymmetricRec(root.left, root.right);
    }

    private static boolean areSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && areSymmetricRec(left.left, right.right) &&
                areSymmetricRec(left.right, right.left);
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
