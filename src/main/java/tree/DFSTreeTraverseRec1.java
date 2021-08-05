package tree;

public class DFSTreeTraverseRec1 {

    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            inOrder(root.left);
        }

        System.out.print(root.val + " ");

        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            postOrder(root.left);
        }

        if (root.right != null) {
            postOrder(root.right);
        }

        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        preOrder(root);

        System.out.println();

        inOrder(root);

        System.out.println();

        postOrder(root);
    }
}
