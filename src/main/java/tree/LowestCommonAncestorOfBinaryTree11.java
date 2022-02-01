package tree;

public class LowestCommonAncestorOfBinaryTree11 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
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
