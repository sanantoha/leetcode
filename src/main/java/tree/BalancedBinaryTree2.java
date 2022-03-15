package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/submissions/
 */
public class BalancedBinaryTree2 {

    public static boolean isBalanced(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        System.out.println(isBalanced(root));


        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));

        System.out.println(isBalanced(root1));
    }
}
