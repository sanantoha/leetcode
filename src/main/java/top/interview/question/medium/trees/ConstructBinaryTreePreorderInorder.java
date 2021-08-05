package top.interview.question.medium.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import top.interview.question.easy.trees.TreeNode;

class Solution2 {

    int preInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> indMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, indMap, 0,preorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, Map<Integer, Integer> indMap, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preInd++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, indMap, l, indMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, indMap, indMap.get(rootVal) + 1, r);
        return root;
    }
}

public class ConstructBinaryTreePreorderInorder {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        int[] pre = {5, 2, 1, 3, 8, 7, 9};
        int[] in = {1, 2, 3, 5, 7, 8, 9};

        System.out.println(s.buildTree(pre, in));
    }
}
