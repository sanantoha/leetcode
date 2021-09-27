package tree;

public class ValidateBinarySearchTree2 {

    public static boolean validate(TreeNode root) {
        if (root == null) return false;

        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private static boolean isValid(TreeNode root, double lo, double hi) {
        if (root == null) return true;
        if (root.val < lo || root.val >= hi) {
            return false;
        }

        return isValid(root.left, lo, root.val) && isValid(root.right, root.val, hi);
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
