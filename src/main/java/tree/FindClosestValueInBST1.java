package tree;

import java.util.Deque;
import java.util.LinkedList;

public class FindClosestValueInBST1 {

    // O(h) time | O(1) space - where h is height of tree and it might be equal to n if tree is unbalanced
    public static int findClosestValueInBst(TreeNode root, int target) {
        if (root == null) return Integer.MAX_VALUE;

        TreeNode curr = root;
        int closest = root.val;

        while (curr != null) {
            int currDiff = Math.abs(curr.val - target);
            int closestDiff = Math.abs(closest - target);
            if (currDiff < closestDiff) {
                closest = curr.val;
            }

            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else return curr.val;
        }

        return closest;
    }

    // O(h) time | O(h) space - where h is height of tree and it might be equal to n if tree is unbalanced
    public static int findClosestValueInBstRec(TreeNode root, int target) {
        return findClosestValueInBstRec(root, target, root.val);
    }

    private static int findClosestValueInBstRec(TreeNode root, int target, int closest) {
        if (root == null) return closest;

        int currDiff = Math.abs(root.val - target);
        int closestDiff = Math.abs(root.val - closest);

        if (currDiff < closestDiff) {
            closest = root.val;
        }

        if (target < root.val) {
            return findClosestValueInBstRec(root.left, target, closest);
        } else if (target > root.val) {
            return findClosestValueInBstRec(root.right, target, closest);
        } else return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(5)),
                new TreeNode(15,
                        new TreeNode(13,
                                null,
                                new TreeNode(14)),
                        new TreeNode(22)));

        System.out.println(findClosestValueInBst(root, 12) == 13);

        System.out.println(findClosestValueInBstRec(root, 12) == 13);
    }
}
