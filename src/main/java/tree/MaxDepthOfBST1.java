package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxDepthOfBST1 {

    public static int maxDepth(TreeNode head) {
        return dfs(head, 0);
    }

    private static int dfs(TreeNode head, int depth) {
        if (head == null) return depth;
        depth++;
        return Math.max(dfs(head.left, depth), dfs(head.right, depth));
    }

    public static int maxDepthDfsIter(TreeNode head) {
        int depth = 0;
        if (head == null) return depth;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(head);
        Deque<Integer> value = new ArrayDeque<>();
        value.push(1);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int tmp = value.pop();
            depth = Math.max(depth, tmp);
            if (curr.left != null) {
                stack.push(curr.left);
                value.push(tmp + 1);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                value.push(tmp + 1);
            }
        }

        return depth;
    }

    public static int maxDepth1(TreeNode head) {
        int depth = 0;
        if (head == null) return depth;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            int size = queue.size();

            depth++;

            while(size-- > 0) {
                TreeNode curr = queue.remove();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(13),
                                new TreeNode(20))));


        System.out.println(maxDepth(head));
        System.out.println(maxDepth1(head));
        System.out.println(maxDepthDfsIter(head));
    }
}
