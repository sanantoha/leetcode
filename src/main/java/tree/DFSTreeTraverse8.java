package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFSTreeTraverse8 {

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return res;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            res.add(curr.val);

            curr = curr.right;
        }

        return res;
    }

    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> fst = new LinkedList<>();
        Deque<TreeNode> snd = new LinkedList<>();
        fst.push(root);

        while (!fst.isEmpty()) {
            TreeNode curr = fst.pop();
            snd.push(curr);

            if (curr.left != null) fst.push(curr.left);
            if (curr.right != null) fst.push(curr.right);
        }

        while (!snd.isEmpty()) {
            res.add(snd.poll().val);
        }
        return res;
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

        System.out.println(preOrder(root)); // 5 2 1 3 8 7 9

        System.out.println(inOrder(root)); // 1 2 3 5 7 8 9

        System.out.println(postOrder(root)); // 1 3 2 7 9 8 5
    }
}
