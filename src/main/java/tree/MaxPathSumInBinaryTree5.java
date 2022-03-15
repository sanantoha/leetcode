package tree;

import java.util.ArrayDeque;

public class MaxPathSumInBinaryTree5 {

    static class BinaryTree {
        public int value;
        public MaxPathSumInBinaryTree4.BinaryTree left;
        public MaxPathSumInBinaryTree4.BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static int maxPathSum(MaxPathSumInBinaryTree4.BinaryTree tree) {
        return -1;
    }


    public static void main(String[] args) {
        MaxPathSumInBinaryTree4.TestBinaryTree test = new MaxPathSumInBinaryTree4.TestBinaryTree(1);
        test.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int actual = maxPathSum(test);
        System.out.println(actual);
        System.out.println(actual == 18);
    }

    static class TestBinaryTree extends MaxPathSumInBinaryTree4.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<MaxPathSumInBinaryTree4.BinaryTree> queue = new ArrayDeque<MaxPathSumInBinaryTree4.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                MaxPathSumInBinaryTree4.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new MaxPathSumInBinaryTree4.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new MaxPathSumInBinaryTree4.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
