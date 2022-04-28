package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static int predInd = 0;

    // O(n) time | O(n) space
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> mapInd = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapInd.put(inorder[i], i);
        }

        return arrayToTree(preorder, mapInd, 0, inorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> mapInd, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[predInd++];
        TreeNode root = new TreeNode(rootVal);

        int rootInordInd = mapInd.get(rootVal);
        root.left = arrayToTree(preorder, mapInd, l, rootInordInd - 1);
        root.right = arrayToTree(preorder, mapInd, rootInordInd + 1, r);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
