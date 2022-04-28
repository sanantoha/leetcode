package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal5 {

    static int idx = 0;

    // O(n) time | O(n) space
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorderMap, 0, preorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int l, int r) {
        if (l > r) return null;

        int value = preorder[idx++];
        TreeNode root = new TreeNode(value);
        root.left = buildTree(preorder, inorderMap, l, inorderMap.get(value) - 1);
        root.right = buildTree(preorder, inorderMap, inorderMap.get(value) + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
