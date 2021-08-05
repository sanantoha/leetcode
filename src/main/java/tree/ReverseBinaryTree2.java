package tree;

public class ReverseBinaryTree2 {

    public static void reverse(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        reverse(root.left);
        reverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15)));

        reverse(tree);

        System.out.println(tree);
    }
}
