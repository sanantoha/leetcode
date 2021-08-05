package tree;

public class ReverseBinaryTree3 {

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
        TreeNode root = new TreeNode(100,
                new TreeNode(50,
                        new TreeNode(25),
                        null),
                new TreeNode(200,
                        new TreeNode(125),
                        new TreeNode(350)));

        reverse(root);

        System.out.println(root);
    }
}
