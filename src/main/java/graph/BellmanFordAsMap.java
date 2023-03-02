package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static graph.GraphUtils.Edge;
import static graph.GraphUtils.printEdgeWeightedDigraph;
import static graph.GraphUtils.edgeWeightedDigraph;
import static graph.GraphUtils.Pair;

public class BellmanFordAsMap {

    // ShortestPath{shortest=[-9.0, -20.0, -18.0, -2.0, -11.0], prev=[4, 2, 4, 0, 1]}
    // [4, 1, 2]
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);
            Map<String, List<Edge<String, Double>>> graph = edgeWeightedDigraph(scanner);
            System.out.println(printEdgeWeightedDigraph(graph));

            var sp = findShortestPath(graph, "0");
            System.out.println(sp);

            List<String> cycle = findNegativeWeightCycle(graph, sp);
            System.out.println(cycle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E * V) time | O(V) space
    private static Pair<Map<String, Double>, Map<String, String>> findShortestPath(Map<String, List<Edge<String, Double>>> graph, String start) {
        Map<String, Double> shortest = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Set<Edge<String, Double>> edges = new HashSet<>();
        for (String key : graph.keySet()) {
            shortest.put(key, Double.POSITIVE_INFINITY);
            edges.addAll(graph.getOrDefault(key, Collections.emptyList()));
        }
        shortest.put(start, 0d);

        for (int i = 0; i < graph.keySet().size() - 1; i++) {
            for (Edge<String, Double> edge : edges) {
                relax(edge, shortest, prev);
            }
        }

        return new Pair<>(shortest, prev);
    }

    private static void relax(Edge<String, Double> edge, Map<String, Double> shortest, Map<String, String> prev) {
        double newWeight = shortest.getOrDefault(edge.from(), Double.NaN) + edge.weight();
        if (newWeight < shortest.get(edge.to())) {
            shortest.put(edge.to(), newWeight);
            prev.put(edge.to(), edge.from());
        }
    }

    // O(E + V) time | O(V) space
    public static List<String> findNegativeWeightCycle(Map<String, List<Edge<String, Double>>> graph, Pair<Map<String, Double>, Map<String, String>> sp) {
        Map<String, Double> shortest = sp.getT1();
        Map<String, String> prev = sp.getT2();

        Set<Edge<String, Double>> edges = new HashSet<>();
        for (String key : graph.keySet()) {
            edges.addAll(graph.getOrDefault(key, Collections.emptyList()));
        }

        String v = null;
        for (Edge<String, Double> edge : edges) {
            if (shortest.getOrDefault(edge.from(), Double.NaN) + edge.weight() < shortest.getOrDefault(edge.to(), Double.NaN)) {
                v = edge.from();
            }
        }

        if (v == null) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        res.add(v);
        String u = prev.getOrDefault(v, null);
        while (!v.equals(u)) {
            res.add(u);
            u = prev.getOrDefault(u, null);
        }
        return res;
    }
}
