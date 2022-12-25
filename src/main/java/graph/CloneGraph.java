package graph;

import java.util.*;

public class CloneGraph {

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
        if (node == null) return null;

        Map<Node, Node> cache = new HashMap<>();
        cache.put(node, new Node(node.val));

        Deque<Node> stack = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            Node currCopy = cache.get(curr);
            for (Node child : curr.neighbors) {
                Node childCopy = cache.get(child);
                if (childCopy == null) {
                    childCopy = new Node(child.val);
                    stack.push(child);
                    cache.put(child, childCopy);
                }
                currCopy.neighbors.add(childCopy);
            }
        }
        return cache.get(node);
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
