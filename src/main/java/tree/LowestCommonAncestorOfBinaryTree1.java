package tree;

public class LowestCommonAncestorOfBinaryTree1 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        node7,
                        new TreeNode(4)));
        TreeNode node1 = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8));

        TreeNode root = new TreeNode(3,
                node5,
                node1
        );

        System.out.println(lowestCommonAncestor(root, node7, node1));
    }
}
