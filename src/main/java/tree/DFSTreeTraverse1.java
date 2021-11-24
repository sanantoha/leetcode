package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DFSTreeTraverse1 {

    public static List<Integer> preOrder(TreeNode root) {
        return null;
    }

    public static List<Integer> inOrder(TreeNode root) {
        return null;
    }

    public static List<Integer> postOrder(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        preOrder(root);

        System.out.println();

        inOrder(root);

        System.out.println();

        postOrder(root);
    }
}
