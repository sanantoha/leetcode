package tree;

public class ValidateBinarySearchTree1 {

    // O(n) time | O(h) space
    public static boolean validate(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;

        if (root.val < minVal || root.val >= maxVal) return false;

        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
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


        System.out.println(validate(new TreeNode(0)));
    }
}
