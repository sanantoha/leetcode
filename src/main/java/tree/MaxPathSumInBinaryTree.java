package tree;

import java.util.ArrayDeque;

/**
 * https://www.algoexpert.io/questions/Max%20Path%20Sum%20In%20Binary%20Tree
 */
public class MaxPathSumInBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space - where h might be log(n) if tree is balanced
    public static int maxPathSum(BinaryTree tree) {
        return findMaxPath(tree).maxPath;
    }

    private static Pair findMaxPath(BinaryTree tree) {
        if (tree == null) return new Pair(0, Integer.MIN_VALUE);

        Pair leftPair = findMaxPath(tree.left);
        Pair rightPair = findMaxPath(tree.right);

        int maxSumChildAsBranch = Math.max(leftPair.maxSumBranch, rightPair.maxSumBranch);
        int maxSumAsBranch = Math.max(maxSumChildAsBranch + tree.value, tree.value);

        int maxSumAsRootNode = Math.max(leftPair.maxSumBranch + tree.value + rightPair.maxSumBranch, maxSumAsBranch);
        int maxPath = Math.max(Math.max(leftPair.maxPath, rightPair.maxPath), maxSumAsRootNode);

        return new Pair(maxSumAsBranch, maxPath);
    }

    static class Pair {
        int maxSumBranch;
        int maxPath;

        public Pair(int maxSumBranch, int maxPath) {
            this.maxSumBranch = maxSumBranch;
            this.maxPath = maxPath;
        }
    }

    public static void main(String[] args) {
        TestBinaryTree test = new TestBinaryTree(1);
        test.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int actual = maxPathSum(test);
        System.out.println(actual);
        System.out.println(actual == 18);
    }

    static class TestBinaryTree extends BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
