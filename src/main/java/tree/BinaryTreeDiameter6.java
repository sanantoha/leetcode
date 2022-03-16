package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter6 {

    // O(n) time | O(h) space
    public static int binaryTreeDiameter(TreeNode root) {
        return getTreeInfo(root).diameter;
    }

    private static TreeInfo getTreeInfo(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo lti = getTreeInfo(root.left);
        TreeInfo rti = getTreeInfo(root.right);

        int newHeight = Math.max(lti.height, rti.height) + 1;
        int newDiameter = Math.max(Math.max(lti.diameter, rti.diameter), lti.height + rti.height);

        return new TreeInfo(newHeight, newDiameter);
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
