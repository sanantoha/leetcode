package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortDFSCycleGraph12 {

    // O(V + E) time | O(V) space
    public static int[] sort(Digraph graph) {
        if (graph == null) return new int[] {};

        int[] visited = new int[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int u = 0; u < graph.V(); u++) {
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
        }

        int[] res = new int[graph.V()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static void dfs(Digraph graph, int[] visited, int v, Deque<Integer> stack) {
        visited[v] = 1;

        for (int u : graph.adj(v)) {
            if (visited[u] == 1) throw new IllegalStateException("cycle in the graph " + v);
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
        }

        visited[v] = 2;
        stack.push(v);
    }

    // O(V + E) time | O(V) space
    public static int[] sortIter(Digraph graph) {
        if (graph == null) return new int[] {};

        int[] cnt = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            for (int u : graph.adj(v)) {
                cnt[u]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean isCycle = true;
        for (int v = 0; v < cnt.length; v++) {
            if (cnt[v] == 0) {
                queue.add(v);
                isCycle = false;
            }
        }

        if (isCycle) throw new IllegalStateException("graph has cycle");

        int[] res = new int[graph.V()];
        int idx = 0;

        while (!queue.isEmpty()) {
            int v = queue.remove();

            res[idx++] = v;

            for (int u : graph.adj(v)) {
                cnt[u]--;
                if (cnt[u] == 0) {
                    queue.add(u);
                }
            }
        }
        if (idx != graph.V()) throw new IllegalStateException("graph has cycle");
        return res;
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
        System.out.println(Arrays.toString(sortIter(graph)));
    }
}
