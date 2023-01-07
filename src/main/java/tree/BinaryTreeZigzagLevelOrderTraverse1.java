package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraverse1 {

    public static List<List<Integer>> zigZag(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(10,
                        new TreeNode(7),
                        new TreeNode(15,
                                new TreeNode(14),
                                new TreeNode(17))));

        // [[5], [10, 2], [1, 3, 7, 15], [17, 14]]
        System.out.println(zigZag(root));
    }
}
