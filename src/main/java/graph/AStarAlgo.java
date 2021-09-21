package graph;

import static org.junit.Assert.assertTrue;

public class AStarAlgo {

    public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        return new int[0][];
    }

    static class Node {
        int hScore; // heuristic score (manhattan distance)
        int gScore; // distance between start node

        public Node(int hScore, int gScore) {
            this.hScore = hScore;
            this.gScore = gScore;
        }

        public int getFScore() {
            return hScore + gScore;
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

        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertTrue(expected[i][j] == actual[i][j]);
            }
        }

    }
}
