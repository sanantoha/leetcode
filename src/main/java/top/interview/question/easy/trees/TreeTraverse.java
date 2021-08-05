package top.interview.question.easy.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.function.Predicate;

public class TreeTraverse {

    public static void dfsRec(TreeNode root, Predicate<Integer> p) {
        if (root == null) return;


        if (root.left != null) {
            dfsRec(root.left, p);
        }

        if (root.right != null) {
            dfsRec(root.right, p);
        }

        if (!p.test(root.val)) return;

    }

    public static void dfs(TreeNode root, Predicate<Integer> p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();

            if (!p.test(node.val)) return;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void bfs(TreeNode root, Predicate<Integer> p) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!p.test(node.val)) return;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2)),
                new TreeNode(20,
                        new TreeNode(7),
                        new TreeNode(25)
                )
        );

        dfsRec(root, i -> {
            System.out.print(i + " ");
            return true;
        });

        System.out.println("\n================");

        bfs(root, i -> {
            System.out.print(i + " ");
            return true;
        });

        System.out.println("\n================");

        dfs(root, i -> {
            System.out.print(i + " ");
            return true;
        });
    }
}
