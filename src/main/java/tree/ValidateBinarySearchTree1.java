package tree;

public class ValidateBinarySearchTree1 {

    private static boolean isValidBST(TreeNode node, double min, double max) {
        if (node == null) return true;
        if (node.val < min || node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static boolean isValidBST(TreeNode node) {
        return isValidBST(node, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
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
