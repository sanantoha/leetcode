package graph;

import java.util.*;

public class CloneGraph1 {
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

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> clonedNodes = new HashMap<>();
        clonedNodes.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            Node currCopy = clonedNodes.get(curr);

            for (Node neighbor : curr.neighbors) {
                Node neighborCopy = clonedNodes.get(neighbor);
                if (neighborCopy == null) {
                    neighborCopy = new Node(neighbor.val);
                    clonedNodes.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
                currCopy.neighbors.add(neighborCopy);
            }
        }
        return clonedNodes.get(node);
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
