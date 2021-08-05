package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public static boolean isSameTree0(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode currL = queue.remove();
            TreeNode currR = queue.remove();

            if (currL == null && currR == null) continue;
            if (currL == null || currR == null) return false;
            if (currL.val != currR.val) return false;

            queue.add(currL.left);
            queue.add(currR.left);

            queue.add(currL.right);
            queue.add(currR.right);
        }

        return true;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode k = new TreeNode(5,
                new TreeNode(6),
                null);

        System.out.println(isSameTree(p, q));
        System.out.println(isSameTree0(p, q));

        System.out.println(isSameTree(null, null));
        System.out.println(isSameTree0(null, null));

        System.out.println(isSameTree(p, k));
        System.out.println(isSameTree0(p, k));
    }
}
