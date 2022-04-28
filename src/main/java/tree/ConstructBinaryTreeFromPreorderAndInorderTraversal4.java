package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal4 {

    private static int preorderIdx = 0;

    // O(n) time | O(n) space
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        Map<Integer, Integer>  inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, inorderMap, 0, preorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> inorderMap, int l, int r) {
        if (l > r) return null;

        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);
        root.left = arrayToTree(preorder, inorderMap, l, inorderMap.get(val) - 1);
        root.right = arrayToTree(preorder, inorderMap, inorderMap.get(val) + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
