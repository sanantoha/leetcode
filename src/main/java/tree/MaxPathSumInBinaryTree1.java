package tree;

import java.util.ArrayDeque;

/**
 * https://www.algoexpert.io/questions/Max%20Path%20Sum%20In%20Binary%20Tree
 */
public class MaxPathSumInBinaryTree1 {

    static class BinaryTree {
        public int value;
        public MaxPathSumInBinaryTree.BinaryTree left;
        public MaxPathSumInBinaryTree.BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int maxPathSum(MaxPathSumInBinaryTree.BinaryTree tree) {
        return -1;
    }

    public static void main(String[] args) {
        MaxPathSumInBinaryTree.TestBinaryTree test = new MaxPathSumInBinaryTree.TestBinaryTree(1);
        test.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int actual = maxPathSum(test);
        System.out.println(actual);
        System.out.println(actual == 18);
    }

    static class TestBinaryTree extends MaxPathSumInBinaryTree.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<MaxPathSumInBinaryTree.BinaryTree> queue = new ArrayDeque<MaxPathSumInBinaryTree.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                MaxPathSumInBinaryTree.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new MaxPathSumInBinaryTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new MaxPathSumInBinaryTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
