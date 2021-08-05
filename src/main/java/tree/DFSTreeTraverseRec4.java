package tree;

import java.util.ArrayList;
import java.util.List;

public class DFSTreeTraverseRec4 {

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private static void preOrderRec(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preOrderRec(root.left, result);
        preOrderRec(root.right, result);
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private static void inOrderRec(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inOrderRec(root.left, result);
        result.add(root.val);
        inOrderRec(root.right, result);
    }

    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private static void postOrderRec(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postOrderRec(root.left, result);
        postOrderRec(root.right, result);
        result.add(root.val);
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
