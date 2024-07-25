package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {

    // O(n) time | O(1) space
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        int minDiff = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            minDiff = Math.min(minDiff, Math.abs(prev - curr.val));

            prev = curr.val;
            curr = curr.right;
        }

        return minDiff;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(6)
        );
        System.out.println(getMinimumDifference(root)); // 1


        TreeNode root1 = new TreeNode(5,
                new TreeNode(0),
                new TreeNode(48,
                        new TreeNode(12),
                        new TreeNode(50)
                )
        );
        System.out.println(getMinimumDifference(root1)); // 2
    }
}
