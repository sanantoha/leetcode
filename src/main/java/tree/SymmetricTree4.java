package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree4 {

    public static boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode root1 = queue.remove();
            TreeNode root2 = queue.remove();

            if (root1 == null && root2 == null) continue;
            if (root1 == null || root2 == null) return false;
            if (root1.val != root2.val) return false;

            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }

        return true;
    }

    public static boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;
        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return root1.val == root2.val && isSymmetricRec(root1.left, root2.right) &&
                isSymmetricRec(root1.right, root2.left);
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
