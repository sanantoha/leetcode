package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree3 {

    public static boolean isSameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;

        return r1.val == r2.val && isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
    }

    public static boolean isSameTreeIter(TreeNode r1, TreeNode r2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(r1);
        queue.add(r2);

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
