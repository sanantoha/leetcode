package tree;

public class BSTSuccessorSearch {

    public static class Node {
        public int key;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int key) {
            this.key = key;
        }
    }

    // O(h) time | O(1) space
    public static Node findInOrderSuccessor(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            return getLeftMostChild(node.right);
        }
        return getRightMostParent(node);
    }

    private static Node getRightMostParent(Node node) {
        Node curr = node;
        while (curr.parent != null && curr.parent.left != curr) {
            curr = curr.parent;
        }
        return curr.parent;
    }

    private static Node getLeftMostChild(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node14 = new Node(14);
        Node node20 = new Node(20);
        Node node25 = new Node(25);

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
