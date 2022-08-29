package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraverse {

    // O(n) time | O(n) space
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = queue.remove();

                subRes.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (i % 2 == 1) {
                Collections.reverse(subRes);
            }
            res.add(subRes);
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        System.out.println(zigzagLevelOrder(root));
    }
}
