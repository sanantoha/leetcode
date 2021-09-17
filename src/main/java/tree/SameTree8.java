package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree8 {

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return true;

        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public static boolean isSameTreeIter(TreeNode t1, TreeNode t2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);

        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.remove();
            TreeNode curr2 = queue.remove();

            if (curr1 == null && curr2 == null) continue;
            if (curr1 == null || curr2 == null) return false;
            if (curr1.val != curr2.val) return false;

            queue.add(curr1.left);
            queue.add(curr2.left);
            queue.add(curr1.right);
            queue.add(curr2.right);
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
