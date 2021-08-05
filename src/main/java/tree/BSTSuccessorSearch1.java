package tree;

import tree.BSTSuccessorSearch.Node;

public class BSTSuccessorSearch1 {

    public static Node findInOrderSuccessor(Node node) {
        if (node == null) return null;

        if (node.right != null) {
            BSTSuccessorSearch.Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        Node curr = node;
        while (curr.parent != null && curr.parent.left != curr) {
            curr = curr.parent;
        }

        return curr.parent;
    }

    public static void main(String[] args) {
        BSTSuccessorSearch.Node node5 = new BSTSuccessorSearch.Node(5);
        BSTSuccessorSearch.Node node9 = new BSTSuccessorSearch.Node(9);
        BSTSuccessorSearch.Node node11 = new BSTSuccessorSearch.Node(11);
        BSTSuccessorSearch.Node node12 = new BSTSuccessorSearch.Node(12);
        BSTSuccessorSearch.Node node14 = new BSTSuccessorSearch.Node(14);
        BSTSuccessorSearch.Node node20 = new BSTSuccessorSearch.Node(20);
        BSTSuccessorSearch.Node node25 = new BSTSuccessorSearch.Node(25);

        node5.parent = node9;

        node9.left = node5;
        node9.right = node12;
        node9.parent = node20;

        node11.parent = node12;

        node12.parent = node9;
        node12.left = node11;
        node12.right = node14;

        node14.parent = node12;

        node20.left = node9;
        node20.right = node25;

        node25.parent = node20;
/*
          20
        /    \
       9      25
     /   \
    5     12
         /   \
        11   14
 */

        System.out.println(findInOrderSuccessor(node5).key == 9);
        System.out.println(findInOrderSuccessor(node9).key == 11);
        System.out.println(findInOrderSuccessor(node11).key == 12);
        System.out.println(findInOrderSuccessor(node12).key == 14);
        System.out.println(findInOrderSuccessor(node14).key == 20);
        System.out.println(findInOrderSuccessor(node20).key == 25);
        System.out.println(findInOrderSuccessor(node25) == null);

        System.out.println(findInOrderSuccessor(node20).key == 25);
    }
}
