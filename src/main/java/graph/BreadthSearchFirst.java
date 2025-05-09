package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BreadthSearchFirst {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(bfs(graph, 0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(V + E) time | O(V) space
    public static List<Integer> bfs(EdgeWeightedDigraph graph, int start) {
        if (graph == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[graph.V()];

        while (!queue.isEmpty()) {
            int v = queue.remove();

            if (visited[v]) continue;
            visited[v] = true;
            res.add(v);

            for (DirectedEdge edge : graph.adj(v)) {
                if (!visited[edge.to()]) {
                    queue.add(edge.to());
                }
            }
        }

        return res;
    }
}
