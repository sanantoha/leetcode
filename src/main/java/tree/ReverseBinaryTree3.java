package tree;

public class ReverseBinaryTree3 {

    public static void reverse(TreeNode root) {

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
