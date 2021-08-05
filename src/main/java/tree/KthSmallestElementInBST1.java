package tree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementInBST1 {

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return Integer.MAX_VALUE;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (k - 1 == 0) return curr.val;
            k--;

            curr = curr.right;
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6)
        );

        System.out.println(kthSmallest(root, 6));
    }
}
