package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraverse1 {

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

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

    public static List<Integer> inorderRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    private static void inorderRec(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorderRec(root.left, result);

        result.add(root.val);

        inorderRec(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(11),
                                new TreeNode(17))));

        System.out.println(inorder(root));
        System.out.println(inorderRec(root));
    }
}
