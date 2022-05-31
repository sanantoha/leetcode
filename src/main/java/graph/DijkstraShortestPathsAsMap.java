package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static graph.GraphUtils.Pair;
import static graph.GraphUtils.Edge;

public class DijkstraShortestPathsAsMap {

    // Pair{t1={0=0.0, 1=5.0, 2=8.0, 3=4.0, 4=7.0}, t2={0=null, 1=3, 2=1, 3=0, 4=3}}
    public static void main(String[] args) {
        String path = "src/main/java/graph/dijkstraShortestPath.txt";
        try (FileReader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            Map<String, List<Edge<String, Double>>> graph = GraphUtils.edgeWeightedDigraph(scanner);
            System.out.println(GraphUtils.printEdgeWeightedDigraph(graph));

            var sp = findShortestPath(graph, "0");
            System.out.println(sp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // O((E + V) * log(V)) time | O(V) space
    public static Pair<Map<String, Double>, Map<String, String>>
            findShortestPath(Map<String, List<Edge<String, Double>>> graph, String start) {
        Map<String, Double> shortest = new HashMap<>(graph.size());
        Map<String, String> prev = new HashMap<>(graph.size());
        for (String key : graph.keySet()) {
            shortest.put(key, Double.POSITIVE_INFINITY);
            prev.put(key, null);
        }
        shortest.put(start, 0d);

        PriorityQueue<Edge<String, Double>> heap =
                new PriorityQueue<>(graph.size(), Comparator.comparingDouble(Edge::weight));
        heap.add(new Edge<>(start, start, 0d));

        while (!heap.isEmpty()) {
            Edge<String, Double> minEdge = heap.remove();
            String v = minEdge.to();

            for (Edge<String, Double> edge : graph.getOrDefault(v, new ArrayList<>())) {
                relax(shortest, prev, edge, heap);
            }
        }

        return new Pair<>(shortest, prev);
    }

    private static void relax(Map<String, Double> shortest,
                              Map<String, String> prev,
                              Edge<String, Double> edge,
                              PriorityQueue<Edge<String, Double>> heap) {
        String from = edge.from();
        String to = edge.to();

        double newWeight = shortest.get(edge.from()) + edge.weight();

        if (newWeight < shortest.get(to)) {
            shortest.put(to, newWeight);
            prev.put(to, from);
            heap.add(edge);
        }
    }
}