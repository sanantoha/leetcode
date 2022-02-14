package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal3 {

    private static int preorderIdx = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        if (preorder.length != inorder.length)
            return null;

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, inOrderMap, 0, preorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> inOrderMap, int l, int r) {
        if (l > r) return null;

        TreeNode root = new TreeNode(preorder[preorderIdx++]);
        root.left = arrayToTree(preorder, inOrderMap, l, inOrderMap.get(root.val) - 1);
        root.right = arrayToTree(preorder, inOrderMap, inOrderMap.get(root.val) + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
