package tree;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
 * Given two binary search trees root1 and root2,
 * return a list containing all the integers from both trees sorted in ascending order.
 */
public class AllElementsInTwoBinarySearchTrees1 {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(9,
                new TreeNode(2),
                new TreeNode(12,
                        new TreeNode(11),
                        new TreeNode(15))
        );


        TreeNode root2 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(1),
                                new TreeNode(4)),
                        new TreeNode(6)),
                new TreeNode(16)
        );

        Object[] expected = {1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 15, 16};

        var actual = getAllElements(root1, root2);

        System.out.println(actual);
        assertArrayEquals(actual.toArray(), expected);
    }
}
