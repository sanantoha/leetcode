package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraverse4 {

    public static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();
            level++;

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                subRes.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (!subRes.isEmpty()) {
                if (level % 2 == 0) {
                    Collections.reverse(subRes);
                }
                res.add(subRes);
            }
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
