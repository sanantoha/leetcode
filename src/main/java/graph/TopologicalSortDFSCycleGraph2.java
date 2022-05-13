package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortDFSCycleGraph2 {

    // O(E + V) time | O(V) space
    public static int[] sort(Digraph graph) {

        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            dfs(graph, stack, visited, v);
        }

        int[] res = new int[graph.V()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    private static void dfs(Digraph graph, Deque<Integer> stack, int[] visited, int v) {
        if (visited[v] != 0) return;
        visited[v] = 1;

        for (int u : graph.adj(v)) {
            if (visited[u] == 1) throw new IllegalStateException("Cycle in the graph " + v);
            dfs(graph, stack, visited, u);
        }
        visited[v] = 2;
        stack.push(v);
    }

    // O(E + V) time | O(V) space
    public static int[] sortIter(Digraph graph) {

        int[] cnt = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            for (int u : graph.adj(v)) {
                cnt[u]++;
            }
        }

        boolean isCycle = true;
        Queue<Integer> queue = new LinkedList<>();

        for (int v = 0; v < cnt.length; v++) {
            int num = cnt[v];
            if (num == 0) {
                queue.add(v);
                isCycle = false;
            }
        }

        if (isCycle) throw new IllegalStateException("Cycle in the graph");

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

        if (idx != graph.V()) throw new IllegalStateException("Cycle in the graph");

        return res;
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
//        graph.addEdge(2, 0);

        System.out.println(graph);

        System.out.println(Arrays.toString(sort(graph)));
        System.out.println(Arrays.toString(sortIter(graph)));
    }
}
