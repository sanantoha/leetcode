package top.interview.question.medium.trees;

import java.util.ArrayList;
import java.util.List;
import top.interview.question.easy.trees.TreeNode;

class Solution0 {

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;

        if (root.left != null) {
            dfs(root.left, res);
        }

        res.add(root.val);

        if (root.right != null) {
            dfs(root.right, res);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
}

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        System.out.println(s.inorderTraversal(root));
    }
}
