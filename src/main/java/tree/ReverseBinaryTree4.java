package tree;

public class ReverseBinaryTree4 {

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
        TreeNode t = new TreeNode(20,
                new TreeNode(50,
                        new TreeNode(75),
                        new TreeNode(25)),
                new TreeNode(200,
                        null,
                        new TreeNode(300)));

        reverse(t);

        System.out.println(t);
    }
}
