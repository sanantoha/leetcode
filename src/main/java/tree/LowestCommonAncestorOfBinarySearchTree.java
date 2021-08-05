package tree;

public class LowestCommonAncestorOfBinarySearchTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));


        System.out.println(lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5)));

        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                null);

        System.out.println(lowestCommonAncestor(root1, new TreeNode(2), new TreeNode(1)));
    }
}
