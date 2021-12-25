package tree;

import java.util.ArrayDeque;

public class MaxPathSumInBinaryTree3 {

    static class BinaryTree {
        public int value;
        public MaxPathSumInBinaryTree2.BinaryTree left;
        public MaxPathSumInBinaryTree2.BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    public static int maxPathSum(MaxPathSumInBinaryTree2.BinaryTree tree) {
        return -1;
    }


    public static void main(String[] args) {
        MaxPathSumInBinaryTree2.TestBinaryTree test = new MaxPathSumInBinaryTree2.TestBinaryTree(1);
        test.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int actual = maxPathSum(test);
        System.out.println(actual);
        System.out.println(actual == 18);
    }

    static class TestBinaryTree extends MaxPathSumInBinaryTree2.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<MaxPathSumInBinaryTree2.BinaryTree> queue = new ArrayDeque<MaxPathSumInBinaryTree2.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                MaxPathSumInBinaryTree2.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new MaxPathSumInBinaryTree2.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new MaxPathSumInBinaryTree2.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
