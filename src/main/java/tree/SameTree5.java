package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree5 {

    public static boolean isSameTree(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        return l.val == r.val && isSameTree(l.left, r.left) && isSameTree(l.right, r.right);
    }

    public static boolean isSameTreeIter(TreeNode l, TreeNode r) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(l);
        queue.add(r);

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
