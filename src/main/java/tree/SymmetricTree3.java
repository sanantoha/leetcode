package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree3 {

    public static boolean isSymmetric(TreeNode root) {

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

    public static boolean isSymmetricRec(TreeNode root) {
        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val &&
                isSymmetricRec(t1.left, t2.right) &&
                isSymmetricRec(t1.right, t2.left);
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
