package tree;

public class DFSTreeTraverseRec {

    public static void preOrderRec(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        if (root.left != null) {
            preOrderRec(root.left);
        }

        if (root.right != null) {
            preOrderRec(root.right);
        }
    }

    public static void inOrderRec(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            inOrderRec(root.left);
        }

        System.out.print(root.val + " ");

        if (root.right != null) {
            inOrderRec(root.right);
        }
    }

    public static void postOrderRec(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            postOrderRec(root.left);
        }

        if (root.right != null) {
            postOrderRec(root.right);
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

        preOrderRec(root); // 5 2 1 3 8 7 9
        System.out.println();
        inOrderRec(root); // 1 2 3 5 7 8 9
        System.out.println();
        postOrderRec(root); // 1 3 2 7 9 8 5
    }
}
