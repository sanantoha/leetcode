package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK6 {

    static class BinaryTree {
        public int value;
        public FindNodesDistanceK5.BinaryTree left = null;
        public FindNodesDistanceK5.BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static List<Integer> findNodesDistanceK(FindNodesDistanceK5.BinaryTree tree, int target, int k) {
        return null;
    }

    public static List<Integer> findNodesDistanceKRec(FindNodesDistanceK5.BinaryTree tree, int target, int k) {
        return null;
    }


    public static void main(String[] args) {
        FindNodesDistanceK5.BinaryTree root = new FindNodesDistanceK5.BinaryTree(1);
        root.left = new FindNodesDistanceK5.BinaryTree(2);
        root.right = new FindNodesDistanceK5.BinaryTree(3);
        root.left.left = new FindNodesDistanceK5.BinaryTree(4);
        root.left.right = new FindNodesDistanceK5.BinaryTree(5);
        root.right.right = new FindNodesDistanceK5.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceK5.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceK5.BinaryTree(8);
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
