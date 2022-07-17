package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static graph.GraphUtils.Edge;

public class BreadthSearchFirstAsMap {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);

            Map<String, List<Edge<String, Double>>> graph = GraphUtils.edgeWeightedDigraph(scanner);
            System.out.println(GraphUtils.printEdgeWeightedDigraph(graph));

            System.out.println(bfs(graph, "0"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V) time | O(V) space
    private static List<String> bfs(Map<String, List<Edge<String, Double>>> graph, String start) {
        if (graph == null) return Collections.emptyList();

        List<String> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            String v = queue.remove();

            if (visited.contains(v)) continue;
            visited.add(v);
            res.add(v);

            for (Edge<String, Double> edge : graph.getOrDefault(v, new ArrayList<>())) {
                queue.add(edge.to());
            }
        }

        return res;
    }
}
