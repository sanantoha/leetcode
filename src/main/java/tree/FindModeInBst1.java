package tree;

import java.util.Arrays;

public class FindModeInBst1 {

    private static int[] findMode(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(2),
                        null
                )
        );
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(5),
                        new TreeNode(7)
                )
        );


        System.out.println(Arrays.toString(findMode(root)));  // [2]
        System.out.println(Arrays.toString(findMode(root1))); // [0]
        System.out.println(Arrays.toString(findMode(root2))); // [3, 5, 7]
    }
}
