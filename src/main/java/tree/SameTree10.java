package tree;

public class SameTree10 {

    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        return false;
    }

    public static boolean isSameTreeIter(TreeNode t1, TreeNode t2) {
        return false;
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
