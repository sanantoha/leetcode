package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSortDFSCycleGraph2 {

    public static int[] sort(Digraph graph) {

        int[] visited = new int[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < graph.V(); i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i, stack);
            }
        }

        int[] result = new int[graph.V()];
        int idx = 0;
        while (!stack.isEmpty()) {
            result[idx++] = stack.pop();
        }

        return result;
    }

    private static void dfs(Digraph graph, int[] visited, int v, Deque<Integer> stack) {
        visited[v] = 1;

        for (Integer u : graph.adj(v)) {
            if (visited[u] == 1) throw new IllegalStateException("Cycle in graph " + v);
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
