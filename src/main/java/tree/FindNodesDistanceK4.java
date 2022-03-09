package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK4 {

    static class BinaryTree {
        public int value;
        public FindNodesDistanceK2.BinaryTree left = null;
        public FindNodesDistanceK2.BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static List<Integer> findNodesDistanceK(FindNodesDistanceK2.BinaryTree tree, int target, int k) {
        return null;
    }

    public static List<Integer> findNodesDistanceKRec(FindNodesDistanceK2.BinaryTree tree, int target, int k) {
        return null;
    }


    public static void main(String[] args) {
        FindNodesDistanceK2.BinaryTree root = new FindNodesDistanceK2.BinaryTree(1);
        root.left = new FindNodesDistanceK2.BinaryTree(2);
        root.right = new FindNodesDistanceK2.BinaryTree(3);
        root.left.left = new FindNodesDistanceK2.BinaryTree(4);
        root.left.right = new FindNodesDistanceK2.BinaryTree(5);
        root.right.right = new FindNodesDistanceK2.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceK2.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceK2.BinaryTree(8);
        int target = 3;
        int k = 2;
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        var actual = findNodesDistanceK(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        System.out.println(expected.equals(actual));

        actual = findNodesDistanceKRec(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        System.out.println(expected.equals(actual));
    }
}
