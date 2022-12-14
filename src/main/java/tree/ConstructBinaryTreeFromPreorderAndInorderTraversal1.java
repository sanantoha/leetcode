package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal1 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        // TreeNode{val=3, left=TreeNode{val=9, left=null, right=null}, right=TreeNode{val=20, left=TreeNode{val=15, left=null, right=null}, right=TreeNode{val=7, left=null, right=null}}}
        System.out.println(root);
    }
}
