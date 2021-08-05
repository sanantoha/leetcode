package top.interview.question.easy.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
 *
 * Maximum Depth of Binary Tree
 *
 * Solution
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */

class Solution0 {

    public int bfsLoop(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            depth++;

            while (size-- > 0) {
                TreeNode current = queue.poll();
//                System.out.println(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return depth;
    }

    public int dfs(TreeNode root, int depth) {
        if (root == null) return depth;

        int newDepth = depth + 1;
        return Math.max(dfs(root.left, newDepth), dfs(root.right, newDepth));
    }

    public int maxDepth(TreeNode root) {
        return bfsLoop(root);
    }
}

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution0 s = new Solution0();

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(s.maxDepth(root));


        System.out.println("============================");

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2));

        System.out.println(s.maxDepth(root1));
    }
}
