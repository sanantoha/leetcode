package graph;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class AStarAlgo6 {

    // O(w * h * log(w * h)) time | O(w * h) space
    public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        if (graph == null || graph.length == 0) return new int[][] {};

        List<List<Node>> nodes = initNodes(graph);
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);
        startNode.distanceFromStart = 0;
        startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(Node::getEstimatedDistanceToEnd));
        heap.add(startNode);

        while (!heap.isEmpty()) {
            Node minNode = heap.remove();

            if (minNode == endNode) {
                break;
            }

            List<Node> neighbors = getNeighbors(nodes, minNode);
            for (Node neighbor : neighbors) {
                if (neighbor.val == 1) continue;
                int tentativeDistanceFromStart = minNode.distanceFromStart + 1;
                if (tentativeDistanceFromStart >= neighbor.distanceFromStart) {
                    continue;
                }
                neighbor.distanceFromStart = tentativeDistanceFromStart;
                neighbor.estimatedDistanceToEnd = tentativeDistanceFromStart + calculateManhattanDistance(neighbor, endNode);
                neighbor.cameFrom = minNode;

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
        if (endNode.cameFrom == null) return new int[][] {};

        Deque<int[]> stack = new LinkedList<>();
        Node curr = endNode;
        int size = 0;
        while (curr != null) {
            stack.push(new int[] {curr.x, curr.y});
            size++;
            curr = curr.cameFrom;
        }

        int[][] res = new int[size][2];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static List<Node> getNeighbors(List<List<Node>> nodes, Node node) {
        List<Node> neighbors = new ArrayList<>();
        int row = node.x;
        int col = node.y;

        if (row > 0) neighbors.add(nodes.get(row - 1).get(col));
        if (col > 0) neighbors.add(nodes.get(row).get(col - 1));
        if (row + 1 < nodes.size()) neighbors.add(nodes.get(row + 1).get(col));
        if (col + 1 < nodes.get(row).size()) neighbors.add(nodes.get(row).get(col + 1));

        return neighbors;
    }

    private static int calculateManhattanDistance(Node start, Node end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
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

    static class Node {
        int x;
        int y;
        int val;
        int distanceFromStart = Integer.MAX_VALUE;
        int estimatedDistanceToEnd = Integer.MAX_VALUE;
        Node cameFrom;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
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
