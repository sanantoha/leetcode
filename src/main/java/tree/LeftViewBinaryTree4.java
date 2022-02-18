package tree;

import java.util.*;

public class LeftViewBinaryTree4 {

    // O(n) time | O(n) space
    public static List<Integer> leftView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean isFirst = true;

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                if (isFirst) {
                    res.add(curr.val);
                    isFirst = false;
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return res;
    }

    /**
     * left view of binary tree
     *          1
     *        /   \
     *       2     3
     *           /  \
     *          4    8
     *        /  \
     *       5    6
     *             \
     *              7
     *  output: [1, 2, 4, 5, 7]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7))),
                        new TreeNode(8)));

        System.out.println(leftView(root));
    }
}
