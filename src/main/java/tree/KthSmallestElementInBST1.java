package tree;

public class KthSmallestElementInBST1 {

    public static int kthSmallestElement(TreeNode root, int k) {
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(8)),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        System.out.println(kthSmallestElement(root, 4));
    }
}
