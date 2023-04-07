package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BranchSums {

    // O(n) time | O(n) space
    public static List<Integer> branchSums(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        backtrack(root, 0, res);
        return res;
    }

    // O(n) time | O(h) space
    public static List<Integer> branchSumsIter(TreeNode root) {

        Deque<Info> stack = new LinkedList<>();
        stack.push(new Info(root, 0));

        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            Info info = stack.pop();
            TreeNode curr = info.tree;
            int sum = info.sum;

            if (curr == null) continue;
            sum += curr.val;
            if (curr.left == null && curr.right == null) {
                res.add(sum);
            }

            stack.push(new Info(curr.left, sum));
            stack.push(new Info(curr.right, sum));
        }
        return res;
    }

    private static void backtrack(TreeNode root, int sum, List<Integer> res) {
        if (root == null) return;

        sum += root.val;
        if (root.left == null && root.right == null) {
            res.add(sum);
            return;
        }

        backtrack(root.left, sum, res);
        backtrack(root.right, sum, res);
    }

    static class Info {
        TreeNode tree;
        int sum;

        public Info(TreeNode tree, int sum) {
            this.tree = tree;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                null)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        System.out.println(branchSums(root)); // [15, 16, 18, 10, 11]
        System.out.println(branchSumsIter(root)); // 11, 10, 18, 16, 15]
    }
}
