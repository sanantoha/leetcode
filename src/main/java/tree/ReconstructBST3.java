package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.algoexpert.io/questions/Reconstruct%20BST
 */
public class ReconstructBST3 {

    // O(n ^ 2) time | O(h) space
    public static TreeNode reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.size() == 0) return null;

        int val = preOrderTraversalValues.get(0);
        TreeNode root = new TreeNode(val);
        List<Integer> remain = preOrderTraversalValues.subList(1, preOrderTraversalValues.size());
        root.left = reconstructBst(remain.stream().filter(x -> x < val).collect(Collectors.toList()));
        root.right = reconstructBst(remain.stream().filter(x -> x > val).collect(Collectors.toList()));
        return root;
    }

    // O(n) time | O(n) space
    public static TreeNode reconstructBst1(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.size() == 0) return null;
        TreeInfo ti = new TreeInfo(0);
        return reconstructBst1(preOrderTraversalValues, ti, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode reconstructBst1(List<Integer> preOrderTraversalValues, TreeInfo ti, int min, int max) {
        if (ti.idx == preOrderTraversalValues.size()) return null;

        int val = preOrderTraversalValues.get(ti.idx);

        if (val < min || val >= max) return null;

        TreeNode root = new TreeNode(val);
        ti.idx++;
        root.left = reconstructBst1(preOrderTraversalValues, ti, min, val);
        root.right = reconstructBst1(preOrderTraversalValues, ti, val, max);
        return root;
    }

    static class TreeInfo {
        int idx;

        public TreeInfo(int idx) {
            this.idx = idx;
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
