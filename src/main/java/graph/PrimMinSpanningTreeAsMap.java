package graph;


import java.util.*;

import static graph.GraphUtils.Edge;
import static graph.GraphUtils.printEdgeWeightedDigraph;

public class PrimMinSpanningTreeAsMap {

    public static void main(String[] args) {
        Map<String, List<Edge<String, Double>>> graph = createGraph();
        System.out.println(printEdgeWeightedDigraph(graph));
        System.out.println("=========================================");
        // [Edge{from=3, to=4, weight=2.0}, Edge{from=2, to=4, weight=3.0}, Edge{from=4, to=5, weight=2.0}, Edge{from=0, to=1, weight=7.0}, Edge{from=1, to=2, weight=3.0}]
        System.out.println(mst(graph));

        System.out.println();
        System.out.println("=========================================");
        System.out.println("=========================================");

        Map<String, List<Edge<String, Double>>> graph1 = createGraph1();
        System.out.println(printEdgeWeightedDigraph(graph1));
        System.out.println("=========================================");
        // [Edge{from=2, to=4, weight=1.0}, Edge{from=0, to=2, weight=3.0}, Edge{from=0, to=1, weight=2.0}, Edge{from=1, to=6, weight=3.0}, Edge{from=5, to=6, weight=2.0}, Edge{from=3, to=4, weight=5.0}]
        System.out.println(mst(graph1));
    }

    private static Map<String, List<Edge<String, Double>>> createGraph1() {
        Map<String, List<Edge<String, Double>>> graph = new HashMap<>();

        Edge<String, Double> edge01 = new Edge<>("0", "1", 2.0);
        Edge<String, Double> edge02 = new Edge<>("0", "2", 3.0);
        Edge<String, Double> edge03 = new Edge<>("0", "3", 7.0);

        Edge<String, Double> edge12 = new Edge<>("1", "2", 6.0);
        Edge<String, Double> edge16 = new Edge<>("1", "6", 3.0);

        Edge<String, Double> edge24 = new Edge<>("2", "4", 1.0);
        Edge<String, Double> edge25 = new Edge<>("2", "5", 8.0);

        Edge<String, Double> edge34 = new Edge<>("3", "4", 5.0);

        Edge<String, Double> edge45 = new Edge<>("4", "5", 4.0);

        Edge<String, Double> edge56 = new Edge<>("5", "6", 2.0);

        graph.put("0", List.of(edge01, edge02, edge03));
        graph.put("1", List.of(edge01, edge12, edge16));
        graph.put("2", List.of(edge02, edge12, edge24, edge25));
        graph.put("3", List.of(edge03, edge34));
        graph.put("4", List.of(edge24, edge34, edge45));
        graph.put("5", List.of(edge25, edge45, edge56));
        graph.put("6", List.of(edge16, edge56));

        return graph;
    }

    private static Map<String, List<Edge<String, Double>>> createGraph() {
        Map<String, List<Edge<String, Double>>> graph = new HashMap<>();

        Edge<String, Double> edge01 = new Edge<>("0", "1", 7.0);
        Edge<String, Double> edge02 = new Edge<>("0", "2", 8.0);

        Edge<String, Double> edge12 = new Edge<>("1", "2", 3.0);
        Edge<String, Double> edge13 = new Edge<>("1", "3", 6.0);

        Edge<String, Double> edge23 = new Edge<>("2", "3", 4.0);
        Edge<String, Double> edge24 = new Edge<>("2", "4", 3.0);

        Edge<String, Double> edge34 = new Edge<>("3", "4", 2.0);
        Edge<String, Double> edge35 = new Edge<>("3", "5", 5.0);

        Edge<String, Double> edge45 = new Edge<>("4", "5", 2.0);

        graph.put("0", List.of(edge01, edge02));
        graph.put("1", List.of(edge01, edge12, edge13));
        graph.put("2", List.of(edge02, edge12, edge23, edge24));
        graph.put("3", List.of(edge13, edge23, edge34, edge35));
        graph.put("4", List.of(edge24, edge34, edge45));
        graph.put("5", List.of(edge35, edge45));
        return graph;
    }

    // O((E + V) * log(V)) time | O(V) space
    public static Set<Edge<String, Double>> mst(Map<String, List<Edge<String, Double>>> graph) {
        Set<Edge<String, Double>> mst = new HashSet<>();

        String start = "0";

        PriorityQueue<Pair> heap = new PriorityQueue<>(graph.size(), Comparator.comparingDouble(p -> p.edge.weight()));

        for (Edge<String, Double> edge : graph.getOrDefault(start, new ArrayList<>())) {
            heap.add(new Pair(edge, start));
        }

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(start, true);

        int inTree = 1;

        while (!heap.isEmpty() && inTree < graph.size()) {
            Pair p = heap.remove();
            Edge<String, Double> minEdge = p.edge;
            String from = p.from;
            String to = p.edge.other(from);

            if (visited.getOrDefault(to, false)) continue;
            visited.put(to, true);
            inTree++;
            mst.add(minEdge);

            for (Edge<String, Double> edge : graph.getOrDefault(to, new ArrayList<>())) {
                heap.add(new Pair(edge, to));
            }
        }

        if (inTree < graph.size()) {
            return Collections.emptySet();
        }

        return mst;
    }

    static class Pair {
        Edge<String, Double> edge;
        String from;

        public Pair(Edge<String, Double> edge, String from) {
            this.edge = edge;
            this.from = from;
        }
    }
}
