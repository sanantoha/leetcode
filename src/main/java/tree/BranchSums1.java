package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BranchSums1 {

    // O(n) time | O(h) space
    public static List<Integer> branchSums(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        branchSumsRec(root, 0, res);
        return res;
    }

    private static void branchSumsRec(TreeNode root, int sum, List<Integer> res) {
        if (root == null) return;

        sum += root.val;
        if (root.left == null && root.right == null) {
            res.add(sum);
        }
        branchSumsRec(root.left, sum, res);
        branchSumsRec(root.right, sum, res);
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
