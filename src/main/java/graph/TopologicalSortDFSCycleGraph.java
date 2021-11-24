package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortDFSCycleGraph {

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 0);

        System.out.println(digraph);

        System.out.println(Arrays.toString(sort(digraph)));
        System.out.println(Arrays.toString(sortIter(digraph)));
    }

    // O(E + V) time | O(V) space
    public static int[] sort(Digraph digraph) {

        int[] visited = new int[digraph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int v = 0; v < digraph.V(); v++) {
            if (visited[v] == 0) {
                dfs(digraph, visited, v, stack);
            }
        }

        int[] result = new int[digraph.V()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    private static void dfs(Digraph digraph, int[] visited, int v, Deque<Integer> stack) {
        visited[v] = 1;

        for (int u : digraph.adj(v)) {
            if (visited[u] == 1) throw new IllegalStateException("Graph has cycle in vertex=" + u);
            if (visited[u] == 0) {
                dfs(digraph, visited, u, stack);
            }
        }
        visited[v] = 2;
        stack.push(v);
    }

    //================================================================================================

    // O(V + E) time | O(V) space
    public static int[] sortIter(Digraph graph) {

        int[] res = new int[graph.V()];

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
}
