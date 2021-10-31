package tree;

public class FindClosestValueInBST2 {

    // O(h) time | O(1) space
    public static int findClosestValueInBst(TreeNode root, int target) {
        if (root == null) return -1;

        TreeNode curr = root;
        int closest = root.val;

        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(closest - target)) {
                closest = curr.val;
            }

            if (curr.val < target) {
                curr = curr.right;
            } else if (curr.val > target) {
                curr = curr.left;
            } else return curr.val;
        }
        return closest;
    }

    // O(h) time | O(h) space
    public static int findClosestValueInBstRec(TreeNode root, int target) {
        return findClosestValueInBstRec(root, target, root.val);
    }

    private static int findClosestValueInBstRec(TreeNode root, int target, int closest) {
        if (root == null) return closest;

        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        if (root.val < target) {
            return findClosestValueInBstRec(root.right, target, closest);
        } else if (root.val > target) {
            return findClosestValueInBstRec(root.left, target, closest);
        } else {
            return root.val;
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
