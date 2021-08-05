package top.interview.question.easy.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class Solution2 {

    public List<Integer> dfs(TreeNode root, boolean isLeft) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();

            if (Integer.MIN_VALUE == node.val) {
                res.add(null);
                continue;
            } else {
                res.add(node.val);
            }

            if (isLeft) {
                if (node.right != null) {
                    stack.push(node.right);
                } else stack.push(nullNode);
                if (node.left != null) {
                    stack.push(node.left);
                } else stack.push(nullNode);
            } else {
                if (node.left != null) {
                    stack.push(node.left);
                } else stack.push(nullNode);
                if (node.right != null) {
                    stack.push(node.right);
                } else stack.push(nullNode);
            }
        }

        return res;
    }

    public List<Integer> dfsL(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return res;
        }

        res.add(root.val);

        return dfsL(root.right, dfsL(root.left, res));
    }

    public List<Integer> dfsR(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return res;
        }

        res.add(root.val);

        return dfsR(root.left, dfsR(root.right, res));
    }

    public boolean isSymmetric(TreeNode root) {
        List<Integer> l = dfs(root.left, true); //dfsL(root.left, new ArrayList<>());
        List<Integer> r = dfs(root.right, false);//dfsR(root.right, new ArrayList<>());
        return l.equals(r);
    }
}

public class SymmetricTree {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                            ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                            )
                );

        System.out.println(s.isSymmetric(root));

        System.out.println("==================================");

        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                )
        );

        System.out.println(s.isSymmetric(root1));
    }
}
