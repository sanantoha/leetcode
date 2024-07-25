package tree;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST1 {


    public static int getMinimumDifference(TreeNode root) {
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(6)
                );
        System.out.println(getMinimumDifference(root)); // 1


        TreeNode root1 = new TreeNode(5,
                new TreeNode(0),
                new TreeNode(48,
                        new TreeNode(12),
                        new TreeNode(50)
                        )
                );
        System.out.println(getMinimumDifference(root1)); // 2
    }
}
