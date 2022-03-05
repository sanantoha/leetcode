package tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/submissions/
 */
public class BalancedBinaryTree {

    // O(n) time | O(h) space
    private static boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    private static Pair dfs(TreeNode root) {
        if (root == null) return new Pair(true, 0);

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        boolean isBalanced = l.balanced && r.balanced && Math.abs(l.height - r.height) <= 1;

        return new Pair(isBalanced, 1 + Math.max(l.height, r.height));
    }

    static class Pair {
        boolean balanced;
        int height;

        public Pair(boolean balanced, int height) {
            this.balanced = balanced;
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
