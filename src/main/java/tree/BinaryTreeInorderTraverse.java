package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraverse {

    private static void dfsRec(TreeNode root, List<Integer> result) {
        if (root == null) return;

        dfsRec(root.left, result);

        result.add(root.val);

        dfsRec(root.right, result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfsRec(root, result);

        return result;
    }

    public static List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return null;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            result.add(curr.val);

            curr = curr.right;
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
                        new TreeNode(15))
        );

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversalIter(root));
    }
}
