package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter3 {

    public static int binaryTreeDiameter(TreeNode root) {
        return getTreeInfo(root).diameter;
    }

    // O(n) time | O(h) space
    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(root.left);
        TreeInfo rightTreeInfo = getTreeInfo(root.right);

        int height = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        int diameter = Math.max(
                Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter),
                leftTreeInfo.height + rightTreeInfo.height
            );

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
