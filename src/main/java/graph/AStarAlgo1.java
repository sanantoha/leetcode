package graph;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class AStarAlgo1 {

    // O(w * h * log(w * h)) time | O(w * h) space
    public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        List<List<Node>> nodes = initNodes(graph);
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);

        startNode.distanceFromStart = 0;
        startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparing(Node::getEstimatedDistanceToEnd));
        heap.add(startNode);

        while (!heap.isEmpty()) {
            Node minNode = heap.remove();

            if (minNode == endNode) {
                break;
            }

            List<Node> neighbors = getNeighbors(minNode, nodes);
            for (Node neighbor : neighbors) {
                if (neighbor.value == 1) continue;

                int tentativeDistanceFromStart = 1 + minNode.distanceFromStart;
                if (tentativeDistanceFromStart >= neighbor.distanceFromStart) {
                    continue;
                }

                neighbor.cameFrom = minNode;
                neighbor.distanceFromStart = tentativeDistanceFromStart;
                neighbor.estimatedDistanceToEnd = tentativeDistanceFromStart + calculateManhattanDistance(neighbor, endNode);

                if (heap.contains(neighbor)) {
                    heap.remove(neighbor);
                    heap.add(neighbor);
                } else {
                    heap.add(neighbor);
                }
            }
        }

        return reconstructPath(endNode);
    }

    private static int[][] reconstructPath(Node endNode) {
        if (endNode.cameFrom == null) {
            return new int[0][];
        }
        Deque<int[]> stack = new LinkedList<>();
        Node curr = endNode;
        while (curr != null) {
            stack.push(new int[] {curr.row, curr.col});
            curr = curr.cameFrom;
        }

        int[][] res = new int[stack.size()][2];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static List<Node> getNeighbors(Node node, List<List<Node>> nodes) {
        List<Node> neighbors = new ArrayList<>();
        if (node.row > 0) {
            neighbors.add(nodes.get(node.row - 1).get(node.col));
        }
        if (node.col > 0) {
            neighbors.add(nodes.get(node.row).get(node.col - 1));
        }
        if (node.row + 1 < nodes.size()) {
            neighbors.add(nodes.get(node.row + 1).get(node.col));
        }
        if (node.col + 1 < nodes.get(node.row).size()) {
            neighbors.add(nodes.get(node.row).get(node.col + 1));
        }
        return neighbors;
    }

    private static int calculateManhattanDistance(Node startNode, Node endNode) {
        return Math.abs(endNode.row - startNode.row) + Math.abs(endNode.col - startNode.col);
    }

    private static List<List<Node>> initNodes(int[][] graph) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int row = 0; row < graph.length; row++) {
            List<Node> lst = new ArrayList<>();
            for (int col = 0; col < graph[row].length; col++) {
                lst.add(new Node(row, col, graph[row][col]));
            }
            nodes.add(lst);
        }
        return nodes;
    }

    static class Node {
        int row;
        int col;
        int value;
        int distanceFromStart;
        int estimatedDistanceToEnd;
        Node cameFrom;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.distanceFromStart = Integer.MAX_VALUE;
            this.estimatedDistanceToEnd = Integer.MAX_VALUE;
        }

        public int getEstimatedDistanceToEnd() {
            return estimatedDistanceToEnd;
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

        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertTrue(expected[i][j] == actual[i][j]);
            }
        }
    }
}
