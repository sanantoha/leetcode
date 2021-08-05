package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {

    static int preOrderIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

        Map<Integer, Integer> inOrdMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrdMap.put(inorder[i], i);
        }

        return buildTree(preorder, inOrdMap, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, Map<Integer, Integer> inOrdMap, int lo, int hi) {
        if (lo > hi) return null;

        int rootVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inOrdMap, lo, inOrdMap.get(rootVal) - 1);
        root.right = buildTree(preorder, inOrdMap, inOrdMap.get(rootVal) + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
