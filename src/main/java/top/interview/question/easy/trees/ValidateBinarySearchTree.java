package top.interview.question.easy.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution1 {

    public boolean isValidBST(TreeNode node, double min, double max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;


        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean dfsLoop(TreeNode root) {
        if (root == null) return false;
        boolean depth = true;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.poll();
            System.out.print(current.val + " ");

            if (current.right != null) {
                if (current.val >= current.right.val) return false;
                stack.push(current.right);
            }

            if (current.left != null) {
                if (current.val <= current.left.val) return false;
                stack.push(current.left);
            }

        }
        return depth;
    }

    public boolean isValidBST0(TreeNode root) {
        return dfsLoop(root);
    }
}

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2)),
                new TreeNode(20,
                        new TreeNode(7),
                        new TreeNode(25)
                )
        );

        System.out.println(s.isValidBST(root));
//
//        System.out.println("============================");
//
//        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//
//        System.out.println(s.isValidBST(root1));
//
//
//        System.out.println("============================");
//
//        TreeNode root2 = new TreeNode(1, new TreeNode(1), null);
//
//        System.out.println(!s.isValidBST(root2));

        System.out.println("============================");

        TreeNode root3 = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6,
                        new TreeNode(3),
                        new TreeNode(7)
                )
        );

        System.out.println(!s.isValidBST(root3));

        System.out.println("============================");

//        TreeNode root4 = new TreeNode(3,
//                new TreeNode(1,
//                        new TreeNode(0),
//                        new TreeNode(2)),
//                new TreeNode(5,
//                        new TreeNode(4),
//                        new TreeNode(6)
//                )
//        );
//
//        System.out.println(s.isValidBST(root4));
//
//        System.out.println("=======================");
//
////        [120,70,140,50,100,130,160,20,55,75,110,119,135,150,200]
//
//        TreeNode root5 = new TreeNode(120,
//                new TreeNode(70,
//                        new TreeNode(50,
//                                new TreeNode(20),
//                                new TreeNode(55)),
//                        new TreeNode(100,
//                                new TreeNode(75),
//                                new TreeNode(110))),
//                new TreeNode(140,
//                        new TreeNode(130,
//                                new TreeNode(119),
//                                new TreeNode(135)),
//                        new TreeNode(160,
//                                new TreeNode(150),
//                                new TreeNode(200))
//                )
//        );
//
//        System.out.println(!s.isValidBST(root5));
    }
}
