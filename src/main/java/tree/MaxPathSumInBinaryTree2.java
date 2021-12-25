package tree;

import java.util.ArrayDeque;

/**
 * https://www.algoexpert.io/questions/Max%20Path%20Sum%20In%20Binary%20Tree
 */
public class MaxPathSumInBinaryTree2 {
    
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int maxSumBranch;
        int maxPath;

        public TreeInfo(int maxSumBranch, int maxPath) {
            this.maxSumBranch = maxSumBranch;
            this.maxPath = maxPath;
        }
    }

    // O(n) time | O(h) space
    public static int maxPathSum(BinaryTree tree) {
        return getTreeInfo(tree).maxPath;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) return new TreeInfo(0, 0);

        TreeInfo tiLeft = getTreeInfo(tree.left);
        TreeInfo tiRight = getTreeInfo(tree.right);

        int maxPathAsChildNodes = Math.max(tiLeft.maxPath, tiRight.maxPath);
        int maxPathAsBranch = Math.max(maxPathAsChildNodes + tree.value, tree.value);
        int maxPathAsRoot = Math.max(maxPathAsBranch, tiLeft.maxSumBranch + tree.value + tiRight.maxSumBranch);

        int maxPath = Math.max(Math.max(maxPathAsRoot, tiLeft.maxPath), tiRight.maxPath);
        return new TreeInfo(maxPathAsBranch, maxPath);
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
