package tree;

import java.util.ArrayDeque;

public class MaxPathSumInBinaryTree6 {

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

        TreeInfo lti = getTreeInfo(tree.left);
        TreeInfo rti = getTreeInfo(tree.right);

        int maxPathAsBranchChild = Math.max(lti.maxPathAsBranch, rti.maxPathAsBranch);
        int maxPathAsBranch = Math.max(tree.value, maxPathAsBranchChild + tree.value);

        int maxPathAsRoot = Math.max(maxPathAsBranch, lti.maxPathAsBranch + tree.value + rti.maxPathAsBranch);
        int maxPath = Math.max(Math.max(maxPathAsRoot, lti.maxPath), rti.maxPath);

        return new TreeInfo(maxPathAsBranch, maxPath);
    }

    static class TreeInfo {
        int maxPathAsBranch;
        int maxPath;

        public TreeInfo(int maxPathAsBranch, int maxPath) {
            this.maxPathAsBranch = maxPathAsBranch;
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
