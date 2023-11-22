package graph;

import java.util.*;

public class TopologicalSortDFSCycleGraph {

    public static void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 4);
//        digraph.addEdge(4, 0);

        digraph.addEdge(2, 4);
        digraph.addEdge(1, 3);

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
//                dfs(digraph, visited, v, stack);
                dfsIter(digraph, visited, v, stack);
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

    record Info(int v, int color) {}

    private static void dfsIter(Digraph digraph, int[] visited, int v, Deque<Integer> res) {

        Deque<Info> stack = new LinkedList<>();
        stack.push(new Info(v, 1));

        Set<Integer> set = new HashSet<>();

        while (!stack.isEmpty()) {
            Info info = stack.pop();

            if (info.color == 2) {
                visited[info.v] = 2;
                continue;
            }
            if (info.color == 1) {
                visited[info.v] = 1;
            }

            for (int u : digraph.adj(info.v)) {
                if (visited[u] == 1) throw new IllegalStateException("Graph has cycle in vertex=" + info.v);
                if (visited[u] == 0) {
                    stack.push(new Info(u, 1));
                }
            }
            if (!set.contains(info.v)) {
                res.add(info.v);
                set.add(info.v);
            }

            stack.push(new Info(info.v, 2));
        }
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
