package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree10 {

    // O(n) time | O(h) space
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    // O(n) time | O(h) space
    public static boolean isSameTreeIter(TreeNode t1, TreeNode t2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);

        while (!queue.isEmpty()) {
            TreeNode c1 = queue.remove();
            TreeNode c2 = queue.remove();

            if (c1 == null && c2 == null) continue;
            if (c1 == null || c2 == null) return false;
            if (c1.val != c2.val) return false;

            queue.add(c1.left);
            queue.add(c2.left);

            queue.add(c1.right);
            queue.add(c2.right);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));

        TreeNode t2 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));

        System.out.println(isSameTree(t1, t2));
        System.out.println(isSameTreeIter(t1, t2));


        TreeNode t11 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));

        TreeNode t22 = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));

        System.out.println(isSameTree(t11, t22));
        System.out.println(isSameTreeIter(t11, t22));
    }
}
