package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeDepths8 {

    public static int nodeDepths(TreeNode root) {
        return -1;
    }

    public static int nodeDepthsRec(TreeNode root) {
        return -1;
    }


    /**
     *  Write function that takes in a Binary Tree and return the sum of its node's depths.
     *  https://www.algoexpert.io/questions/Node%20Depths
     *            1
     *          /   \
     *         2     3
     *       /  \  /  \
     *     4    5 6    7
     *   / \
     *  8   9
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        System.out.println(nodeDepths(root) == 16);
        System.out.println(nodeDepthsRec(root) == 16);
    }
}
