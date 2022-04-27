package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraverse9 {

    // O(n) time | O(n) space
    public static List<List<Integer>> zigZag(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                subRes.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (i % 2 == 1) {
                Collections.reverse(subRes);
            }
            i++;
            res.add(subRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));


        System.out.println(zigZag(root));
    }
}
