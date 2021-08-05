package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree2 {

    public static boolean isSameTree(TreeNode h1, TreeNode h2) {
        if (h1 == null && h2 == null) return true;
        if (h1 == null || h2 == null) return false;

        return h1.val == h2.val && isSameTree(h1.left, h2.left) && isSameTree(h1.right, h2.right);
    }

    public static boolean isSameTreeIter(TreeNode h1, TreeNode h2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(h1);
        queue.add(h2);

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
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        TreeNode t2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        System.out.println(isSameTree(t1, t2));
        System.out.println(isSameTreeIter(t1, t2));
    }
}
