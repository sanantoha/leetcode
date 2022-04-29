package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST4 {

    public static TreeNode reconstructBst(List<Integer> preOrderTraversalValues) {
        return null;
    }

    public static TreeNode reconstructBst1(List<Integer> preOrderTraversalValues) {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(2);
        tree.left.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right = new TreeNode(17);
        tree.right.right = new TreeNode(19);
        tree.right.right.left = new TreeNode(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        var actual = reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(actualValues);
        System.out.println(expected.equals(actualValues));

        actual = reconstructBst1(preOrderTraversalValues);
        actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(actualValues);
        System.out.println(expected.equals(actualValues));
    }

    public static List<Integer> getDfsOrder(TreeNode node, List<Integer> values) {
        values.add(node.val);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }
}
