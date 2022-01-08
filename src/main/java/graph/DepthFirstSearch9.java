package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch9 {

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

    // O(V + E) time | O(V) space
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
            dfsRec(graph, visited, edge.to(), res);
        }
    }

    // O(E + V) time | O(v) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];

        visited[start] = true;
        res.add(start);

        Iterator<DirectedEdge>[] arrIter = new Iterator[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            arrIter[v] = graph.adj(v).iterator();
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (arrIter[v].hasNext()) {
                DirectedEdge edge = arrIter[v].next();
                int to = edge.to();
                if (!visited[to]) {
                    visited[to] = true;
                    res.add(to);
                    stack.push(to);
                }
            } else {
                stack.pop();
            }
        }

        return res;
    }
}
