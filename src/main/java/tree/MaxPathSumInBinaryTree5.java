package tree;

import java.util.ArrayDeque;

public class MaxPathSumInBinaryTree5 {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static int maxPathSum(BinaryTree tree) {
        return getTreeInfo(tree).maxPath;
    }

    // O(n) time | O(h) space
    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) return new TreeInfo(0, 0);

        TreeInfo li = getTreeInfo(tree.left);
        TreeInfo ri = getTreeInfo(tree.right);

        int maxPathAsChildBranch = Math.max(li.maxPathBranch, ri.maxPathBranch);
        int maxPathBranch = Math.max(maxPathAsChildBranch + tree.value, tree.value);

        int maxPathAsRoot = Math.max(maxPathBranch, li.maxPathBranch + tree.value + ri.maxPathBranch);

        int maxPath = Math.max(Math.max(li.maxPath, ri.maxPath), maxPathAsRoot);

        return new TreeInfo(maxPathBranch, maxPath);
    }

    static class TreeInfo {
        int maxPathBranch;
        int maxPath;

        public TreeInfo(int maxPathBranch, int maxPath) {
            this.maxPathBranch = maxPathBranch;
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
