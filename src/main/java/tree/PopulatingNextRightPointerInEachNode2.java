package tree;

public class PopulatingNextRightPointerInEachNode2 {

    public static Node connect(Node root) {
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5),
                        null),
                new Node(3,
                        new Node(6),
                        new Node(7),
                        null),
                null
        );

        System.out.println(connect(root));

        System.out.println(root);
    }
}
