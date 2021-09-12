package graph;

import java.util.*;

public class TopologicalSortDFSCycleGraph5 {

    public static int[] sort(Digraph graph) {
        if (graph == null) return new int[] {};

        int[] res = new int[graph.V()];
        int[] visited = new int[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < graph.V(); i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i, stack);
            }
        }

        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static void dfs(Digraph graph, int[] visited, int v, Deque<Integer> stack) {
        visited[v] = 1;

        for (int u : graph.adj(v)) {
            if (visited[u] == 1) throw new IllegalStateException("graph has cycle in " + v);
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
        }

        visited[v] = 2;
        stack.push(v);
    }


    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 0);

        System.out.println(graph);

        System.out.println(Arrays.toString(sort(graph)));
    }
}
