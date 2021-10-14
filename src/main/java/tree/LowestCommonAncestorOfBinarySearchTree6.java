package tree;

public class LowestCommonAncestorOfBinarySearchTree6 {

    // O(h) time | O(1) space
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
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
