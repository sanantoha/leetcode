package tree;

public class FindClosestValueInBST {

    // O(n) time | O(1) space -- worst case
    public static int findClosestValueInBst(TreeNode root, int target) {
        if (root == null) return 0;

        TreeNode curr = root;
        int closest = root.val;

        while (curr != null) {
            if (Math.abs(closest - target) > Math.abs(curr.val - target)) {
                closest = curr.val;
            }
            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }

        return closest;
    }

    // O(n) time | O(n) space -- worst case
    public static int findClosestValueInBstRec(TreeNode root, int target) {
        return findClosestValueInBstRec(root, target, root.val);
    }

    private static int findClosestValueInBstRec(TreeNode root, int target, int closest) {
        if (root == null) return closest;

        if (Math.abs(closest - target) > Math.abs(root.val - target)) {
            closest = root.val;
        }

        if (target < root.val) {
            return findClosestValueInBstRec(root.left, target, closest);
        } else if (target > root.val) {
            return findClosestValueInBstRec(root.right, target, closest);
        } else {
            return closest;
        }
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
