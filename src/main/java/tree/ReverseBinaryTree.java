package tree;

public class ReverseBinaryTree {

    public static void reverse(TreeNode head) {
        if (head == null) return;

        TreeNode left = head.left;
        TreeNode right = head.right;
        head.left = right;
        head.right = left;
        reverse(head.left);
        reverse(head.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(13),
                                new TreeNode(20))));

        System.out.println(head);

        reverse(head);

        System.out.println(head);
    }
}
