package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // O(n) time | O(h) space
    public static boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;

        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    // O(n) time | O(n) time
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode currL = queue.remove();
            TreeNode currR = queue.remove();
            if (currL == null && currR == null) continue;
            if (currL == null || currR == null) return false;
            if (currL.val != currR.val) return false;
            queue.add(currL.left);
            queue.add(currR.right);
            queue.add(currL.right);
            queue.add(currR.left);
        }

        return true;
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
