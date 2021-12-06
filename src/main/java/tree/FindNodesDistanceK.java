package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);
        int target = 3;
        int k = 2;
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        var actual = findNodesDistanceK(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        System.out.println(expected.equals(actual));
    }
}
