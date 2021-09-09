package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BreadthSearchFirst5 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            List<Integer> res = bfs(graph, 0);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> bfs(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            res.add(v);
            for (DirectedEdge edge : graph.adj(v)) {
                int u = edge.to();
                if (!visited[u]) {
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
        return res;
    }
}
