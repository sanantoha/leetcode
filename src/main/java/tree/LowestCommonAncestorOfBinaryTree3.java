package tree;

public class LowestCommonAncestorOfBinaryTree3 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) return root;

        return (l != null) ? l : r;
    }

    public static void main(String[] args) {
        /*
                 3
              /     \
             5       1
           /   \    /  \
          6     2  0    8
               / \
              7   4
         */
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

        System.out.println(lowestCommonAncestor(root, node7, node5));
    }
}
