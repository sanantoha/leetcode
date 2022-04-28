package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal1 {

    private static int preOrdInd = 0;

    // O(n) time | O(n) space
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        Map<Integer, Integer> inordMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inordMap.put(inorder[i], i);
        }


        return arrayToTree(preorder, inordMap, 0, inorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> inordMap, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preOrdInd++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, inordMap, l, inordMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inordMap, inordMap.get(rootVal) + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
