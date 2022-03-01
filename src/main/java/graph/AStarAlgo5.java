package graph;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class AStarAlgo5 {

    // O(w * h * log(w * h)) time | O(w * h) space
    public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        if (graph == null || graph.length == 0) return new int[][] {};

        List<List<Node>> nodes = initNodes(graph);
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);
        startNode.distanceFromStart = 0;
        startNode.estimateDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(Node::getEstimateDistanceToEnd));
        heap.add(startNode);

        while (!heap.isEmpty()) {
            Node curr = heap.remove();

            if (curr == endNode) break;

            List<Node> neighbors = getNeighbors(nodes, curr);
            for (Node neighbor : neighbors) {
                if (neighbor.val == 1) continue;

                int tentativeDistance = 1 + curr.distanceFromStart;
                if (tentativeDistance >= neighbor.distanceFromStart) continue;

                neighbor.distanceFromStart = tentativeDistance;
                neighbor.estimateDistanceToEnd = tentativeDistance + calculateManhattanDistance(neighbor, endNode);
                neighbor.cameFrom = curr;

                if (heap.contains(neighbor)) {
                    heap.remove(neighbor);
                }
                heap.add(neighbor);
            }
        }

        return buildPath(endNode);
    }

    private static int[][] buildPath(Node endNode) {
        if (endNode.cameFrom == null) return new int[][] {};

        Deque<int[]> stack = new LinkedList<>();
        Node curr = endNode;
        int size = 0;

        while (curr != null) {
            stack.push(new int[] {curr.row, curr.col});
            curr = curr.cameFrom;
            size++;
        }

        int idx = 0;
        int[][] res = new int[size][2];
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static List<Node> getNeighbors(List<List<Node>> nodes, Node node) {
        List<Node> neighbors = new ArrayList<>();

        if (node.row > 0) neighbors.add(nodes.get(node.row - 1).get(node.col));
        if (node.col > 0) neighbors.add(nodes.get(node.row).get(node.col - 1));
        if (node.row + 1 < nodes.size()) neighbors.add(nodes.get(node.row + 1).get(node.col));
        if (node.col + 1 < nodes.get(node.row).size()) neighbors.add(nodes.get(node.row).get(node.col + 1));

        return neighbors;
    }

    private static int calculateManhattanDistance(Node node1, Node node2) {
        return Math.abs(node1.row - node2.row) + Math.abs(node1.col - node2.col);
    }

    private static List<List<Node>> initNodes(int[][] graph) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodes.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                nodes.get(i).add(new Node(i, j, graph[i][j]));
            }
        }
        return nodes;
    }

    private static class Node {
        int row;
        int col;
        int val;
        int distanceFromStart = Integer.MAX_VALUE;
        int estimateDistanceToEnd = Integer.MAX_VALUE;
        Node cameFrom;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int getEstimateDistanceToEnd() {
            return estimateDistanceToEnd;
        }
    }

    public static void main(String[] args) {
        int startRow = 0;
        int startCol = 1;
        int endRow = 4;
        int endCol = 3;

        int[][] graph = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };

        int[][] expected = new int[][] {
                {0, 1},
                {0, 0},
                {1, 0},
                {2, 0},
                {2, 1},
                {3, 1},
                {4, 1},
                {4, 2},
                {4, 3}
        };

        int[][] actual = aStarAlgorithm(startRow, startCol, endRow, endCol, graph);
        System.out.println(Arrays.deepToString(actual));
        System.out.println(Arrays.deepToString(expected));

        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertTrue(expected[i][j] == actual[i][j]);
            }
        }
    }
}
