package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch4 {

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
            if (!visited[edge.to()]) dfsRec(graph, visited, edge.to(), res);
        }
    }

    public static List<Integer> dfs(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            adjArr[i] = graph.adj(i).iterator();
        }

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adjArr[v].hasNext()) {
                DirectedEdge edge = adjArr[v].next();
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

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dfs.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            List<Integer> resRec = dfsRec(graph, 0);
            List<Integer> res = dfs(graph, 0);
            System.out.println(resRec);
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
