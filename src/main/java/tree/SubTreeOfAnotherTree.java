package tree;

import java.util.Deque;
import java.util.LinkedList;

public class SubTreeOfAnotherTree {

    // O(t1 * t2) time | O(h1) space
    public static boolean isSubtree(TreeNode root, TreeNode subTree) {

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();
            if (curr == null) continue;

            if (isSameTree(curr, subTree)) return true;

            stack.push(curr.right);
            stack.push(curr.left);
        }
        return false;
    }

    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(t1);
        stack.push(t2);

        while (!stack.isEmpty()) {
            TreeNode curr1 = stack.poll();
            TreeNode curr2 = stack.poll();

            if (curr1 == null && curr2 == null) continue;
            if (curr1 == null || curr2 == null) return false;
            if (curr1.val != curr2.val) return false;

            stack.push(curr1.left);
            stack.push(curr2.left);
            stack.push(curr1.right);
            stack.push(curr2.right);
        }

        return true;
    }

    public static void main(String[] args) {
        // Creating root1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.right = new TreeNode(5);

        // Creating subTree
        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        // Test isSubtree for root1
        System.out.println(isSubtree(root1, subTree)); // true

        // Creating root2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(0);
        root2.right = new TreeNode(5);

        // Test isSubtree for root2
        System.out.println(isSubtree(root2, subTree)); // false

        // Creating root3
        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(4);
        root3.left.left = new TreeNode(4);
        root3.left.left.left = new TreeNode(4);
        root3.left.left.left.left = new TreeNode(4);
        root3.left.left.left.left.left = new TreeNode(1);
        root3.left.left.left.left.right = new TreeNode(2);

        // Test isSubtree for root3
        System.out.println(isSubtree(root3, subTree)); // true
    }
}
