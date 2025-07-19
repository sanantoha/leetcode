package tree;

public class SubTreeOfAnotherTree1 {
    public static boolean isSubtree(TreeNode root, TreeNode subTree) {
        return false;
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
