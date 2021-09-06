package tree;

import java.util.List;

/**
 * left view of binary tree
 *          1
 *        /   \
 *       2     3
 *              \
 *               6
 *  output: [1, 2, 6]
 */
public class LeftViewBinaryTree {

    public static List<Integer> leftView(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        null,
                        new TreeNode(6)));

        System.out.println(leftView(root));
    }
}
