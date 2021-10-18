package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch7 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dfs.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(dfsRec(graph, 0));
            System.out.println(dfsIter(graph, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V) time | O(V) space
    public static List<Integer> dfsRec(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];
        dfsRec(graph, visited, start, res);
        return res;
    }

    private static void dfsRec(EdgeWeightedDigraph graph, boolean[] visited, int v, List<Integer> res) {
        if (visited[v]) return;

        visited[v] = true;
        res.add(v);

        for (DirectedEdge edge : graph.adj(v)) {
            if (!visited[edge.to()]) {
                dfsRec(graph, visited, edge.to(), res);
            }
        }
    }

    // O(E + V) time | O(V) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);

        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        Iterator<DirectedEdge>[] arrAdj = new Iterator[graph.V()];
        for (int u = 0; u < graph.V(); u++) {
            arrAdj[u] = graph.adj(u).iterator();
        }

        while (!stack.isEmpty()) {
            int v = stack.peek();
            Iterator<DirectedEdge> iter = arrAdj[v];
            if (iter.hasNext()) {
                DirectedEdge edge = iter.next();
                if (!visited[edge.to()]) {
                    visited[edge.to()] = true;
                    res.add(edge.to());
                    stack.push(edge.to());
                }
            } else {
                stack.pop();
            }
        }
        return res;
    }
}
