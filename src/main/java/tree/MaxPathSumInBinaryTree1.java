package tree;

import java.util.ArrayDeque;

/**
 * https://www.algoexpert.io/questions/Max%20Path%20Sum%20In%20Binary%20Tree
 */
public class MaxPathSumInBinaryTree1 {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space
    public static int maxPathSum(BinaryTree tree) {
        return getTreeInfo(tree).maxPath;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo li = getTreeInfo(tree.left);
        TreeInfo ri = getTreeInfo(tree.right);

        int maxSumAsChildBranch = Math.max(li.maxSumBranch, ri.maxSumBranch);
        int maxSumAsBranch = Math.max(maxSumAsChildBranch + tree.value, tree.value);
        int maxSumAsRootNode = Math.max(maxSumAsBranch, li.maxSumBranch + tree.value + ri.maxSumBranch);

        int maxPath = Math.max(Math.max(li.maxPath, ri.maxPath), maxSumAsRootNode);
        return new TreeInfo(maxSumAsBranch, maxPath);
    }
    
    static class TreeInfo {
        int maxSumBranch;
        int maxPath;

        public TreeInfo(int maxSumBranch, int maxPath) {
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
