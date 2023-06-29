package tree;

import java.util.List;

public class BranchSums1 {

    public static List<Integer> branchSums(TreeNode root) {
        return null;
    }

    public static List<Integer> branchSumsIter(TreeNode root) {
        return null;
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
        System.out.println(branchSumsIter(root)); // 11, 10, 18, 16, 15]
    }
}
