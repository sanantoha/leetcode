package tree;

import java.util.List;

public class DFSTreeTraverseRec2 {

    public static List<Integer> preOrderRec(TreeNode root) {
        return null;
    }

    public static List<Integer> inOrderRec(TreeNode root) {
        return null;
    }

    public static List<Integer> postOrderRec(TreeNode root) {
        return null;
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
