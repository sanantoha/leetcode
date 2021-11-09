package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSortDFSCycleGraph7 {

    // O(V + E) time | O(V) space
    public static int[] sort(Digraph graph) {
        int[] res = new int[graph.V()];
        int[] visited = new int[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int v = 0; v < graph.V(); v++) {
            if (visited[v] == 0) {
                dfs(graph, visited, v, stack);
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
            if (visited[u] == 1) throw new IllegalStateException("graph has cycle vertex " + v);
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
        }
        stack.push(v);
        visited[v] = 2;
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
