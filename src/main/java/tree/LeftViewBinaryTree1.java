package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBinaryTree1 {

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean isFirstInLayer = true;

            while (size-- > 0) {
                TreeNode curr = queue.remove();
                if (isFirstInLayer) {
                    isFirstInLayer = false;
                    res.add(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(6,
                                        null,
                                        new TreeNode(7))),
                        new TreeNode(8)));

        System.out.println(leftView(root));
    }
}
