package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinaryTree2 {

    // O(n) time | O(n) space
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean isFstFromLeft = false;

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                if (!isFstFromLeft) {
                    res.add(curr.val);
                    isFstFromLeft = true;
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
