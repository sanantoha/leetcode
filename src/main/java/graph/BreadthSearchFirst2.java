package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BreadthSearchFirst2 {
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

    // O(E + V) time | O(V) space
    public static List<Integer> bfs(EdgeWeightedDigraph graph, int start) {
        List<Integer> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[graph.V()];

        while (!queue.isEmpty()) {
            int v = queue.remove();
            if (visited[v]) continue;
            res.add(v);
            visited[v] = true;
            for (DirectedEdge edge : graph.adj(v)) {
                if (!visited[edge.to()]) {
                    queue.add(edge.to());
                }
            }
        }
        return res;
    }
}
