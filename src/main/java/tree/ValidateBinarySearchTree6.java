package tree;

public class ValidateBinarySearchTree6 {

    // O(n) time | O(h) space
    public static boolean validate(TreeNode root) {
        return isValidTree(root, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    private static boolean isValidTree(TreeNode root, double minValue, double maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val >= maxValue) return false;


        return isValidTree(root.left, minValue, root.val) && isValidTree(root.right, root.val, maxValue);
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
