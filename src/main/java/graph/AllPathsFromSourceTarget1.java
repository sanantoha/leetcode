package graph;

import java.util.List;

public class AllPathsFromSourceTarget1 {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return null;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {1, 2},
                {3},
                {3},
                {}
        };

        var actual = allPathsSourceTarget(graph);
        System.out.println(actual); // [[0, 1, 3], [0, 2, 3]]

        int[][] graph1 = new int[][] {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        actual = allPathsSourceTarget(graph1);
        System.out.println(actual); // [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    }
}
