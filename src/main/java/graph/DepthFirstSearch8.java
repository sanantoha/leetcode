package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch8 {

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
        dfsRec(graph, start, visited, res);
        return res;
    }

    private static void dfsRec(EdgeWeightedDigraph graph, int v, boolean[] visited, List<Integer> res) {
        if (visited[v]) return;

        res.add(v);
        visited[v] = true;

        for (DirectedEdge edge : graph.adj(v)) {
            if (!visited[edge.to()]) {
                dfsRec(graph, edge.to(), visited, res);
            }
        }
    }

    // O(E + V) time | O(V) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);

        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            adjArr[i] = graph.adj(i).iterator();
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adjArr[v].hasNext()) {
                DirectedEdge edge = adjArr[v].next();
                if (!visited[edge.to()]) {
                    visited[edge.to()] = true;
                    stack.push(edge.to());
                    res.add(edge.to());
                }
            } else {
                stack.pop();
            }
        }

        return res;
    }
}
