package tree;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        // condition depends on BST property: left node is less and right is less or equal the root node.

        if (node.val < min || node.val >= max) return false;

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }


    public static boolean isValidBST(TreeNode node) {
        return isValidBST(node, Long.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2)),
                new TreeNode(20,
                        new TreeNode(7),
                        new TreeNode(25)
                )
        );

        System.out.println(isValidBST(root));
    }
}
