package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch5 {
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

    // O(E * V) time | O(E) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;

        @SuppressWarnings("unchecked")
        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            adjArr[v] = graph.adj(v).iterator();
        }

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adjArr[v].hasNext()) {
                DirectedEdge edge = adjArr[v].next();
                int u = edge.to();
                if (!visited[u]) {
                    stack.push(u);
                    visited[u] = true;
                    res.add(u);
                }
            } else stack.pop();
        }

        return res;
    }

    // O(E * V) time | O(E) space
    public static List<Integer> dfsRec(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];

        dfsRec(graph, visited, start, res);

        return res;
    }

    private static void dfsRec(EdgeWeightedDigraph graph, boolean[] visited, int v, List<Integer> res) {
        visited[v] = true;
        res.add(v);

        for (DirectedEdge edge : graph.adj(v)) {
            int u = edge.to();
            if (!visited[u]) {
                dfsRec(graph, visited, u, res);
            }
        }
    }
}
