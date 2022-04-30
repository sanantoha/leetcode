package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter7 {

    // O(n) time | O(h) space
    public static int binaryTreeDiameter(TreeNode root) {
        return getTreeInfo(root).diameter;
    }

    private static Ti getTreeInfo(TreeNode root) {
        if (root == null) return new Ti(0, 0);

        Ti left = getTreeInfo(root.left);
        Ti right = getTreeInfo(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);

        return new Ti(diameter, height);
    }

    static class Ti {
        int diameter;
        int height;

        public Ti(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
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
