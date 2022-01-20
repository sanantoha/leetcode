package tree;

public class ValidateBinarySearchTree7 {

    // O(n) time | O(h) space
    public static boolean validate(TreeNode root) {
        return isValid(root, Double.MIN_VALUE, Double.MAX_VALUE);
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
