package tree;

import java.util.*;

public class BFSTreeTraverse1 {

    public static List<Integer> bfs(TreeNode root) {
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
                                new TreeNode(13),
                                new TreeNode(17))));

        System.out.println(bfs(root)); // [5, 2, 10, 1, 3, 7, 15, 13, 17]
    }
}
