package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 *
 * Given two binary search trees root1 and root2,
 * return a list containing all the integers from both trees sorted in ascending order.
 */
public class AllElementsInTwoBinarySearchTrees {

    // O(n + m) time | O(n + m) space
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        TreeNode curr1 = root1;
        TreeNode curr2 = root2;

        List<Integer> res = new ArrayList<>();

        while (!stack1.isEmpty() || curr1 != null || !stack2.isEmpty() || curr2 != null) {

            while (curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
            }

            while (curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
                curr1 = stack1.pop();
                res.add(curr1.val);
                curr1 = curr1.right;
            } else {
                curr2 = stack2.pop();
                res.add(curr2.val);
                curr2 = curr2.right;
            }
        }
        return res;
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
