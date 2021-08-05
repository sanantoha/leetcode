package graph;

import java.util.*;

public class CloneGraph5 {

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

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            Node currCopy = map.get(curr);
            for (Node v : curr.neighbors) {
                Node vCopy = map.get(v);
                if (vCopy == null) {
                    vCopy = new Node(v.val);
                    stack.push(v);
                    map.put(v, vCopy);
                }
                currCopy.neighbors.add(vCopy);
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
