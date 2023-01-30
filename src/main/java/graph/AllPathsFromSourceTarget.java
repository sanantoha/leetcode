package graph;

import java.util.*;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathsFromSourceTarget {

    // O(2 ^ V * V ^ 2) time | O(2 ^ V) space
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return Collections.emptyList();

        int start = 0;
        Deque<Pair> stack = new LinkedList<>();
        stack.push(new Pair(start, List.of(start)));

        List<List<Integer>> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int v = p.node;
            List<Integer> path = p.lst;

            if (v == graph.length - 1) {
                res.add(new ArrayList<>(path));
            }

            for (int u : graph[v]) {
                List<Integer> np = new ArrayList<>(path);
                np.add(u);
                stack.push(new Pair(u, np));
            }
        }

        return res;
    }

    static class Pair {
        int node;
        List<Integer> lst;

        public Pair(int node, List<Integer> lst) {
            this.node = node;
            this.lst = lst;
        }
    }

    // O(V * 2 ^ V) time | O(V) space
    public static List<List<Integer>> allPathsSourceTargetRec(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        dfs(graph, start, ans, res);
        return res;
    }

    private static void dfs(int[][] graph, int v, List<Integer> ans, List<List<Integer>> res) {
        if (v == graph.length - 1) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int u : graph[v]) {
            ans.add(u);
            dfs(graph, u, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {1, 2},
                {3},
                {3},
                {}
        };

        var actual = allPathsSourceTarget(graph);
        var actualRec = allPathsSourceTargetRec(graph);
        System.out.println(actual); // [[0, 1, 3], [0, 2, 3]]
        System.out.println(actualRec); // [[0, 1, 3], [0, 2, 3]]

        int[][] graph1 = new int[][] {
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}
        };

        actual = allPathsSourceTarget(graph1);
        actualRec = allPathsSourceTargetRec(graph1);
        System.out.println(actual); // [[0,4], [0,3,4], [0,1,3,4], [0,1,2,3,4], [0,1,4]]
        System.out.println(actualRec); // [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]
    }
}
