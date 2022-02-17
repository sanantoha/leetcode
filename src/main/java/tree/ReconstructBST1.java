package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.algoexpert.io/questions/Reconstruct%20BST
 */
public class ReconstructBST1 {

    // O(n ^ 2) time | O(n) space
    public static TreeNode reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.size() == 0)
            return null;

        int rootVal = preOrderTraversalValues.get(0);
        List<Integer> lst = preOrderTraversalValues.subList(1, preOrderTraversalValues.size());
        TreeNode root = new TreeNode(rootVal);
        root.left = reconstructBst(lst.stream().filter(x -> x < rootVal).collect(Collectors.toList()));
        root.right = reconstructBst(lst.stream().filter(x -> x >= rootVal).collect(Collectors.toList()));
        return root;
    }

    public static TreeNode reconstructBst1(List<Integer> preorder) {
        if (preorder == null || preorder.size() == 0) return null;
        TreeInfo ti = new TreeInfo(0);
        return reconstructBstFromRange(preorder, ti, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode reconstructBstFromRange(List<Integer> preorder, TreeInfo ti, int minValue, int maxValue) {
        if (ti.currIdx == preorder.size()) {
            return null;
        }

        int rootVal = preorder.get(ti.currIdx);
        if (rootVal < minValue || rootVal >= maxValue) return null;

        ti.currIdx++;

        TreeNode root = new TreeNode(rootVal);
        root.left = reconstructBstFromRange(preorder, ti, minValue, rootVal);
        root.right = reconstructBstFromRange(preorder, ti, rootVal, maxValue);
        return root;
    }

    static class TreeInfo {
        int currIdx;

        public TreeInfo(int currIdx) {
            this.currIdx = currIdx;
        }
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
