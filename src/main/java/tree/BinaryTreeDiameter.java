package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter {

    static class TreeInfo {

        int diameter;
        int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // O(n) time | O(h) space
    public static int binaryTreeDiameter(TreeNode root) {
        return getTreeInfo(root).diameter;
    }

    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo leftInfo = getTreeInfo(root.left);
        TreeInfo rightInfo = getTreeInfo(root.right);

        int longestPath = leftInfo.height + rightInfo.height;
        int maxDiameter = Math.max(leftInfo.diameter, rightInfo.diameter);
        int diameter = Math.max(longestPath, maxDiameter);
        int height = 1 + Math.max(leftInfo.height, rightInfo.height);

        return new TreeInfo(diameter, height);
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
