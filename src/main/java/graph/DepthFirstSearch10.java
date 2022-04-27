package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch10 {

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
        dfsRecursive(graph, visited, start, res);
        return res;
    }

    private static void dfsRecursive(EdgeWeightedDigraph graph, boolean[] visited, int v, List<Integer> res) {
        if (visited[v]) return;

        res.add(v);
        visited[v] = true;

        for (DirectedEdge edge : graph.adj(v)) {
            dfsRecursive(graph, visited, edge.to(), res);
        }
    }

    // O(V + E) time | O(V) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {

        List<Integer> res = new ArrayList<>();

        Iterator<DirectedEdge>[] iter = new Iterator[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            iter[v] = graph.adj(v).iterator();
        }

        boolean[] visited = new boolean[graph.V()];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        visited[start] = true;
        res.add(start);


        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (iter[v].hasNext()) {
                DirectedEdge edge = iter[v].next();
                if (!visited[edge.to()]) {
                    res.add(edge.to());
                    visited[edge.to()] = true;
                    stack.push(edge.to());
                }
            } else {
                stack.pop();
            }
        }

        return res;
    }
}
