package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraverse2 {

    public static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(Collections.singletonList(root.val));

        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();

            while (size-- > 0) {
                TreeNode curr = queue.remove();

                if (curr.left != null) {
                    queue.add(curr.left);
                    subRes.add(curr.left.val);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                    subRes.add(curr.right.val);
                }
            }

            if (!subRes.isEmpty()) {
                if (i % 2 == 0) Collections.reverse(subRes);
                result.add(subRes);
            }
            i++;
        }

        return result;
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
