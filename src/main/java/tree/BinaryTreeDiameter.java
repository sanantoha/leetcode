package tree;

/**
 *   https://www.algoexpert.io/questions/Binary%20Tree%20Diameter
 */
public class BinaryTreeDiameter {

    public static int binaryTreeDiameter(TreeNode root) {
        return -1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(7,
                                new TreeNode(8,
                                        new TreeNode(9),
                                        null),
                                null),
                        null),
                new TreeNode(2)
        );

        System.out.println(binaryTreeDiameter(tree)); // 6
    }
}
