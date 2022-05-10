package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindClosestValueInBST6 {

    // O(h) time | O(1) space
    public static int findClosestValueInBst(TreeNode root, int target) {

        TreeNode curr = root;
        int closest = root.val;

        while (curr != null) {

            if (Math.abs(target - curr.val) < Math.abs(target - closest)) {
                closest = curr.val;
            }
            if (curr.val > target) {
                curr = curr.left;
            } else if (curr.val < target) {
                curr = curr.right;
            } else return curr.val;

        }

        return closest;
    }

    // O(h) time | O(h) space
    public static int findClosestValueInBstRec(TreeNode root, int target) {
        return findClosestValueInBstRec(root, root.val, target);
    }

    private static int findClosestValueInBstRec(TreeNode root, int closest, int target) {
        if (root == null) return closest;

        if (Math.abs(target - root.val) < Math.abs(target - closest)) {
            closest = root.val;
        }

        if (root.val < target) {
            return findClosestValueInBstRec(root.right, closest, target);
        } else if (root.val > target) {
            return findClosestValueInBstRec(root.left, closest, target);
        }
        return root.val;
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

        int actual = findClosestValueInBst(root, 12);
        System.out.println(actual);
        System.out.println(actual == 13);

        System.out.println(findClosestValueInBstRec(root, 12) == 13);
    }
}
