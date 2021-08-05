package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSTreeTraverse1 {

    public static void preOrder(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();

            System.out.print(node.val + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {

            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.poll();

            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> fst = new ArrayDeque<>();
        Deque<TreeNode> snd = new ArrayDeque<>();

        fst.push(root);

        while (!fst.isEmpty()) {
            TreeNode node = fst.poll();
            snd.push(node);

            if (node.left != null) {
                fst.push(node.left);
            }

            if (node.right != null) {
                fst.push(node.right);
            }
        }

        while (!snd.isEmpty()) {
            TreeNode node = snd.poll();
            System.out.print(node.val + " ");
        }
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
