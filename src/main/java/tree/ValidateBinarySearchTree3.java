package tree;

public class ValidateBinarySearchTree3 {

    public static boolean validate(TreeNode root) {
        if (root == null) return true;

        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private static boolean isValid(TreeNode root, double min, double max) {
        if (root == null) return true;
        if (root.val < min || root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));


        System.out.println(validate(root));
    }
}
