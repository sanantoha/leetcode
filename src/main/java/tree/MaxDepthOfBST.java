package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxDepthOfBST {

    private static int dfs(TreeNode root, int depth) {
        if (root == null) return depth;

        depth++;
        return Math.max(dfs(root.left, depth), dfs(root.right, depth));
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public static int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        return 1 + Math.max(dfsIter(root.left), dfsIter(root.right));
    }

    public static int dfsIter(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> value = new ArrayDeque<>();
        stack.push(root);
        value.push(1);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int tmp = value.pop();
            depth = Math.max(tmp, depth);
            if (curr.right != null) {
                stack.push(curr.right);
                value.push(tmp + 1);
            }

            if (curr.left != null) {
                stack.push(curr.left);
                value.push(tmp + 1);
            }
        }

        return depth;
    }

    public static int maxDepthBfs(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            depth++;

            while (size-- > 0) {
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
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        null),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(20,
                                null,
                                new TreeNode(25)))
        );

        System.out.println(maxDepth(root));
        System.out.println(maxDepth1(root));
        System.out.println(maxDepthBfs(root));

        System.out.println("============================");

        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(maxDepth(root1));
        System.out.println(maxDepth1(root1));
        System.out.println(maxDepthBfs(root1));


        System.out.println("============================");

        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));

        System.out.println(maxDepth(root2));
        System.out.println(maxDepth1(root2));
        System.out.println(maxDepthBfs(root2));
    }
}