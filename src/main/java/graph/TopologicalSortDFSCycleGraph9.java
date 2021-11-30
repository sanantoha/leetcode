package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortDFSCycleGraph9 {

    // O(E + V) time | O(V) space
    public static int[] sort(Digraph graph) {

        int[] visited = new int[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int v = 0; v < graph.V(); v++) {
            if (visited[v] == 0) {
                dfs(graph, visited, v, stack);
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
            if (visited[u] == 1) throw new IllegalStateException("Graph has cycle in " + v);
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
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

        Queue<Integer> queue = new LinkedList<>();
        boolean flag = false;
        for (int v = 0; v < cnt.length; v++) {
            if (cnt[v] == 0) {
                queue.add(v);
                flag = true;
            }
        }

        if (!flag) throw new IllegalStateException("Graph has cycle");

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

        if (idx != graph.V()) throw new IllegalStateException("Graph has cycle");

        return res;
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        System.out.println(graph);

        System.out.println(Arrays.toString(sort(graph)));

//        System.out.println(Arrays.toString(sortIter(graph)));
    }
}
