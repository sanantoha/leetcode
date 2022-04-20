package graph;

import java.util.*;

public class CloneGraph2 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // O(E + V) time | O(V) space
    public static Node cloneGraph(Node node) {
        if (node == null) return node;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            Node currCopy = map.get(curr);

            for (Node child : curr.neighbors) {
                Node childCopy = map.get(child);
                if (childCopy == null) {
                    childCopy = new Node(child.val);
                    map.put(child, childCopy);
                    queue.add(child);
                }
                currCopy.neighbors.add(childCopy);
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node res = cloneGraph(n1);

        System.out.println(res);
    }
}
