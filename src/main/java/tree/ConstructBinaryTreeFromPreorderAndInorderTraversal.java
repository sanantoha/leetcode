package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // O(n) time | O(n) space
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length)
            return null;

        Map<Integer, Integer> inOrderMapping = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMapping.put(inorder[i], i);
        }

        var index = new Index(0);

        return helper(preorder, inOrderMapping, index, 0, preorder.length - 1);
    }

    private static TreeNode helper(int[] prevorder, Map<Integer, Integer> inOrderMapping, Index index, int l, int r) {
        if (l > r) return null;

        int val = prevorder[index.idx++];
        TreeNode node = new TreeNode(val);

        int mid = inOrderMapping.get(val);
        node.left = helper(prevorder, inOrderMapping, index, l, mid - 1);
        node.right = helper(prevorder, inOrderMapping, index, mid + 1, r);
        return node;
    }

    static class Index {
        int idx;

        public Index(int idx) {
            this.idx = idx;
        }
    }


    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
