package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSTreeTraverseRec2 {

    public static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    public static void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5,
//                new TreeNode(2,
//                        new TreeNode(1),
//                        new TreeNode(3)),
//                new TreeNode(10,
//                        new TreeNode(7),
//                        new TreeNode(15,
//                                new TreeNode(13),
//                                new TreeNode(20))));

        TreeNode root = new TreeNode(5,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );


        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        System.out.println(res); // 5 2 1 3 8 7 9

        System.out.println("=============================");

        List<Integer> res1 = new ArrayList<>();
        inOrder(root, res1);
        System.out.println(res1);



        System.out.println("=============================");

        List<Integer> res2 = new ArrayList<>();
        postOrder(root, res2);
        System.out.println(res2); // 1 3 2 7 9 8 5
    }
}
