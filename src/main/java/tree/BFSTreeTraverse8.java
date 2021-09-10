package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTreeTraverse8 {

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            res.add(curr.val);

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);

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
                                new TreeNode(13),
                                new TreeNode(17))));

        System.out.println(bfs(root));
    }
}
