package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal5 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
