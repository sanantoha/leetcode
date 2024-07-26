package tree;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 *
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 *
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right
 * subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
 * The rule is similar if the node does not have a right child.
 *
 *         1
 *       /  \
 *     2     3
 *
 * Input: root = [1,2,3]
 * Output: 1
 * Explanation:
 * Tilt of node 2 : |0-0| = 0 (no children)
 * Tilt of node 3 : |0-0| = 0 (no children)
 * Tilt of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
 * Sum of every tilt : 0 + 0 + 1 = 1
 *
 *
 *                  4
 *               /    \
 *             2       9
 *           /  \       \
 *         3     5       7
 *
 *
 * Input: root = [4,2,9,3,5,null,7]
 * Output: 15
 * Explanation:
 * Tilt of node 3 : |0-0| = 0 (no children)
 * Tilt of node 5 : |0-0| = 0 (no children)
 * Tilt of node 7 : |0-0| = 0 (no children)
 * Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
 * Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
 * Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
 * Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15
 */
public class BinaryTreeTilt {

    // O(n) time | O(h) space
    public static int findTilt(TreeNode root) {
        return helper(root).tilt;
    }

    private static Info helper(TreeNode root) {
        if (root == null) return new Info(0, 0);

        Info li = helper(root.left);
        Info ri = helper(root.right);

        int sum = li.sum + ri.sum + root.val;
        int tilt = Math.abs(li.sum - ri.sum) + li.tilt + ri.tilt;
        return new Info(tilt, sum);
    }

    static record Info(int tilt, int sum) {}

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        System.out.println(findTilt(root) == 1);


        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(5)),
                new TreeNode(9,
                        null,
                        new TreeNode(7))
        );

        System.out.println(findTilt(root1) == 15);


        TreeNode root2 = new TreeNode(21,
                new TreeNode(7,
                        new TreeNode(1,
                                new TreeNode(3),
                                new TreeNode(3)),
                        new TreeNode(1)),
                new TreeNode(14,
                        new TreeNode(2),
                        new TreeNode(2))
        );

        System.out.println(findTilt(root2) == 9);
    }
}
