package tree;

public class FindClosestValueInBST4 {

    public static int findClosestValueInBst(TreeNode root, int target) {
        return -1;
    }

    public static int findClosestValueInBstRec(TreeNode root, int target) {
        return -1;
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
