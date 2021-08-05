package tree;

import java.util.ArrayList;
import java.util.List;

public class DFSTreeTraverseRec6 {

    public static List<Integer> preOrderRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private static void preOrderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preOrderRecursive(root.left, result);
        preOrderRecursive(root.right, result);
    }

    public static List<Integer> inOrderRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private static void inOrderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inOrderRecursive(root.left, result);
        result.add(root.val);
        inOrderRecursive(root.right, result);
    }

    public static List<Integer> postOrderRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private static void postOrderRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postOrderRecursive(root.left, result);
        postOrderRecursive(root.right, result);
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

        System.out.println(preOrderRec(root)); // 5 2 1 3 8 7 9
        System.out.println();
        System.out.println(inOrderRec(root)); // 1 2 3 5 7 8 9
        System.out.println();
        System.out.println(postOrderRec(root)); // 1 3 2 7 9 8 5
    }
}
