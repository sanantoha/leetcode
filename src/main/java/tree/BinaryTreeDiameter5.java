package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter5 {

    public static int binaryTreeDiameter(TreeNode root) {
        return getTreeInfo(root).diameter;
    }

    // O(n) time | O(h) space
    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null) return new TreeInfo(0, Integer.MIN_VALUE);

        TreeInfo left = getTreeInfo(root.left);
        TreeInfo right = getTreeInfo(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int diameter = Math.max(Math.max(left.height + right.height, left.diameter), right.diameter);

        return new TreeInfo(height, diameter);
    }

    static class TreeInfo {
        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(7,
                                new TreeNode(8,
                                        new TreeNode(9),
                                        null),
                                null),
                        new TreeNode(4,
                                null,
                                new TreeNode(5,
                                        null,
                                        new TreeNode(6)))),
                new TreeNode(2)
        );

        System.out.println(binaryTreeDiameter(tree)); // 6
    }
}
