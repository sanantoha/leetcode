package top.interview.question.medium.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import top.interview.question.easy.trees.TreeNode;

class Solution4 {

    public int dfs(TreeNode root, int k) {
        if (root == null) return -1;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.poll();

            if (k == 0) return curr.val;
            k--;

            curr = curr.right;
        }

        return -1;
    }

    public void dfs(TreeNode root, List<Integer> lst) {
        if (root == null) return;

        if (root.left != null) {
            dfs(root.left, lst);
        }
        lst.add(root.val);
        if (root.right != null) {
            dfs(root.right, lst);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> lst = new ArrayList<>();
//        dfs(root, lst);
//        return lst.get(k - 1);
        return dfs(root, k - 1);
    }
}

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4)
        );

        System.out.println(s.kthSmallest(root, 1));



        System.out.println("============================");

        TreeNode root1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6)
        );

        System.out.println(s.kthSmallest(root1, 3));
        System.out.println("============================");



        TreeNode root2 = new TreeNode(4,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(5));
        System.out.println(s.kthSmallest(root2, 1));
        System.out.println("============================");
    }
}
