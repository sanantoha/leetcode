package tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums1 {

    // O(n) time | O(n) space
    public static List<Integer> branchSums(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        backtrack(root, 0, res);
        return res;
    }

    private static void backtrack(TreeNode root, int val, List<Integer> res) {
        if (root == null) return;

        int sum = val + root.val;
        if (root.left == null && root.right == null) {
            res.add(sum);
        }

        backtrack(root.left, sum, res);
        backtrack(root.right, sum, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                null)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        System.out.println(branchSums(root)); // [15, 16, 18, 10, 11]
    }
}
