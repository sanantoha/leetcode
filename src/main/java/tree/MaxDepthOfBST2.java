package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBST2 {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthRec(root, 0);
    }

    private static int maxDepthRec(TreeNode root, int depth) {
        if (root == null) return depth;
        depth++;
        return Math.max(maxDepthRec(root.left, depth), maxDepthRec(root.right, depth));
    }

    public static int maxDepthBfs(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
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

    public static int maxDepthDfsIter(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Deque<Integer> value = new LinkedList<>();
        value.push(1);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            Integer tmp = value.pop();
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
        System.out.println(maxDepthBfs(root));
        System.out.println(maxDepthDfsIter(root));

        System.out.println("============================");

        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(maxDepth(root1));
        System.out.println(maxDepthBfs(root1));
        System.out.println(maxDepthDfsIter(root1));


        System.out.println("============================");

        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));

        System.out.println(maxDepth(root2));
        System.out.println(maxDepthBfs(root2));
        System.out.println(maxDepthDfsIter(root2));
    }
}
