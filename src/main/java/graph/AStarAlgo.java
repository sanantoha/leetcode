package graph;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AStarAlgo {

    // O(w * h * log(w * h)) time | O(h * w) space
    public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        List<List<Node>> nodes = initNodes(graph);
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);

        startNode.distanceFromStart = 0;
        startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getEstimatedDistanceToEnd));
        pq.add(startNode);

        while (!pq.isEmpty()) {
            Node minNode = pq.remove();

            if (minNode == endNode) {
                break;
            }

            List<Node> neighbors = getNeightboringNodes(minNode, nodes);
            for (Node neighbor : neighbors) {
                if (neighbor.value == 1) {
                    continue;
                }

                int tentativeDistance = minNode.distanceFromStart + 1;
                if (tentativeDistance >= neighbor.distanceFromStart) {
                    continue;
                }

                neighbor.prev = minNode;
                neighbor.distanceFromStart = tentativeDistance;
                neighbor.estimatedDistanceToEnd = tentativeDistance + calculateManhattanDistance(neighbor, endNode);

                if (pq.contains(neighbor)) {
                    pq.remove(neighbor);
                    pq.add(neighbor);
                } else {
                    pq.add(neighbor);
                }
            }
        }

        return reconstructPath(endNode);
    }

    private static int[][] reconstructPath(Node endNode) {
        if (endNode.prev == null) return new int[0][];

        Node curr = endNode;
        List<List<Integer>> paths = new ArrayList<>();

        while (curr != null) {
            List<Integer> path = new ArrayList<>(2);
            path.add(curr.row);
            path.add(curr.col);
            paths.add(path);
            curr = curr.prev;
        }

        int[][] res = new int[paths.size()][2];
        for (int i = 0; i < paths.size(); i++) {
            res[i][0] = paths.get(paths.size() - 1 - i).get(0);
            res[i][1] = paths.get(paths.size() - 1 - i).get(1);
        }
        return res;
    }

    private static List<Node> getNeightboringNodes(Node node, List<List<Node>> nodes) {
        List<Node> res = new ArrayList<>();

        int row = node.row;
        int col = node.col;

        if (row > 0) res.add(nodes.get(row - 1).get(col));
        if (col > 0) res.add(nodes.get(row).get(col - 1));
        if (row + 1 < nodes.size()) res.add(nodes.get(row + 1).get(col));
        if (col + 1 < nodes.get(row).size()) res.add(nodes.get(row).get(col + 1));

        return res;
    }

    private static int calculateManhattanDistance(Node startNode, Node endNode) {
        return Math.abs(startNode.row - endNode.row) + Math.abs(startNode.col - endNode.col);
    }

    private static List<List<Node>> initNodes(int[][] graph) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int row = 0; row < graph.length; row++) {
            List<Node> nodeList = new ArrayList<>();
            for (int col = 0; col < graph[row].length; col++) {
                nodeList.add(new Node(row, col, graph[row][col]));
            }
            nodes.add(nodeList);
        }
        return nodes;
    }

    static class Node {
        int row;
        int col;
        int value;
        int estimatedDistanceToEnd;
        int distanceFromStart;
        Node prev;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.estimatedDistanceToEnd = Integer.MAX_VALUE;
            this.distanceFromStart = Integer.MAX_VALUE;
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

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }

    }
}
