package tree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementInBST {

    // O(k) time | O(h) space
    public static int kthSmallestElement(TreeNode root, int k) {
        if (root == null) return Integer.MIN_VALUE;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (k - 1 == 0) return curr.val;
            k--;

            curr = curr.right;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(8)),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        System.out.println(kthSmallestElement(root, 4));
    }
}
