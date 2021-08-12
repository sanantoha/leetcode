package tree;

public class ReverseBinaryTree6 {

    public static void reverse(TreeNode root) {
        if (root == null) return;

        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        reverse(root.left);
        reverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        reverse(root);

        System.out.println(root);
    }
}
