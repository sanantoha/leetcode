package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSortDFSCycleGraph1 {
    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        int[] sortedVertices = sort(graph);
        System.out.println(Arrays.toString(sortedVertices));
    }

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

    private static void dfs(Digraph graph, int[] visited, int i, Deque<Integer> stack) {
        visited[i] = 1;

        for (int v : graph.adj(i)) {
            if (visited[v] == 1) throw new IllegalStateException("Graph has cycle " + v);
            if (visited[v] == 0) dfs(graph, visited, v, stack);
        }
        stack.push(i);
        visited[i] = 2;
    }
}
