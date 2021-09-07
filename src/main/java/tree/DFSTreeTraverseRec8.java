package tree;

import java.util.ArrayList;
import java.util.List;

public class DFSTreeTraverseRec8 {

    public static List<Integer> preOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderRec(root, res);
        return res;
    }

    private static void preOrderRec(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        preOrderRec(root.left, res);
        preOrderRec(root.right, res);
    }

    public static List<Integer> inOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderRec(root, res);
        return res;
    }

    private static void inOrderRec(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inOrderRec(root.left, res);
        res.add(root.val);
        inOrderRec(root.right, res);
    }

    public static List<Integer> postOrderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderRec(root, res);
        return res;
    }

    private static void postOrderRec(TreeNode root, List<Integer> res) {
        if (root == null) return;

        postOrderRec(root.left, res);
        postOrderRec(root.right, res);
        res.add(root.val);
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
