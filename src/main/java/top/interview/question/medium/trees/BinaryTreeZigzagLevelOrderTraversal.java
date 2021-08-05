package top.interview.question.medium.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import top.interview.question.easy.trees.TreeNode;

class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        res.add(Collections.singletonList(root.val));

        int j = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    subRes.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    subRes.add(node.right.val);
                }
            }
            if (subRes.size() > 0) {
                if (j % 2 == 0) Collections.reverse(subRes);
                res.add(subRes);
                j++;
            }

        }
        return res;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );

        System.out.println(s.zigzagLevelOrder(root));

        System.out.println("===============================");

        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        System.out.println(s.zigzagLevelOrder(root1));

        TreeNode root2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        null,
                        new TreeNode(5)));

        System.out.println(s.zigzagLevelOrder(root2));
    }
}
