package graph;

import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 */
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
