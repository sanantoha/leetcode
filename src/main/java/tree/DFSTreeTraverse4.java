package tree;

import java.util.List;

public class DFSTreeTraverse4 {

    public static List<Integer> preOrder(TreeNode root) {
        return null;
    }

    public static List<Integer> inOrder(TreeNode root) {
        return null;
    }

    public static List<Integer> postOrder(TreeNode root) {
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


        List<Integer> res = preOrder(root);
        System.out.println(res); // 5 2 1 3 8 7 9

        System.out.println("=============================");

        List<Integer> res1 = inOrder(root);
        System.out.println(res1);



        System.out.println("=============================");

        List<Integer> res2 = postOrder(root);
        System.out.println(res2); // 1 3 2 7 9 8 5
    }
}
