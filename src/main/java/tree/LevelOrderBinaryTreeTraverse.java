package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTreeTraverse {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> lst = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    lst.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    lst.add(node.right.val);
                }
            }
            if (!lst.isEmpty()) {
                res.add(lst);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        null,
                        new TreeNode(5))
        );

        System.out.println(levelOrder(root1));
    }
}
