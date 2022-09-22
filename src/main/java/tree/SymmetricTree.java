package tree;

import java.util.Deque;
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

    // O(n) time | O(h) space
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode c1 = stack.poll();
            TreeNode c2 = stack.poll();
            if (c1 == null && c2 == null) continue;
            if (c1 == null || c2 == null) return false;
            if (c1.val != c2.val) return false;

            stack.push(c1.left);
            stack.push(c2.right);
            stack.push(c1.right);
            stack.push(c2.left);
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
