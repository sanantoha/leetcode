package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/submissions/
 */
public class BalancedBinaryTree1 {

    // O(n) time | O(h) space
    public static boolean isBalanced(TreeNode root) {
        return getTreeInfo(root).isBalanced;
    }

    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null) return new TreeInfo(true, 0);

        TreeInfo l = getTreeInfo(root.left);
        TreeInfo r = getTreeInfo(root.right);

        boolean isBalanced = l.isBalanced && r.isBalanced && Math.abs(l.height - r.height) <= 1;

        return new TreeInfo(isBalanced, Math.max(l.height, r.height) + 1);
    }

    static class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
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
