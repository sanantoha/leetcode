package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/digraph.txt")) {
            Scanner scanner = new Scanner(reader);

            Digraph graph = new Digraph(scanner);
            System.out.println(graph);

            int[] linear = sort(graph);
            int[] linear1 = sort1(graph);
            // [8, 9, 1, 0, 2, 3, 4, 5, 10, 11, 6, 7, 12, 13]
            System.out.println(Arrays.toString(linear));
            // [0, 1, 8, 2, 9, 4, 3, 5, 6, 10, 7, 11, 12, 13]
            System.out.println(Arrays.toString(linear1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V) time | O(V) space
    private static int[] sort1(Digraph graph) {
        int[] res = new int[graph.V()];

        int[] cnt = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            for (int u : graph.adj(v)) {
                cnt[u]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean isCycle = true;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                isCycle = false;
                queue.add(i);
            }
        }

        if (isCycle) throw new IllegalStateException("cycle in the graph");

        int idx = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();

            res[idx++] = v;

            for (int u : graph.adj(v)) {
                cnt[u]--;
                if (cnt[u] == 0) {
                    queue.add(u);
                }
            }
        }

        if (idx != graph.V()) throw new IllegalStateException("cycle in the graph");

        return res;
    }

    // O(E + V) time | O(V) space
    private static int[] sort(Digraph graph) {
        int[] res = new int[graph.V()];

        Deque<Integer> stack = new LinkedList<>();
        int[] visited = new int[graph.V()];

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
            if (visited[u] == 1) throw new IllegalStateException("graph has cycle " + v);
            if (visited[u] == 0) {
                dfs(graph, visited, u, stack);
            }
        }

        visited[v] = 2;
        stack.push(v);
    }
}
