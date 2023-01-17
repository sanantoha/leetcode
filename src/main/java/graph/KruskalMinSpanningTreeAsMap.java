package graph;

import java.util.*;

import static graph.GraphUtils.printEdgeWeightedDigraph;
import static graph.GraphUtils.Edge;

public class KruskalMinSpanningTreeAsMap {

    public static void main(String[] args) {
        Map<String, List<GraphUtils.Edge<String, Double>>> graph = createGraph();
        System.out.println(printEdgeWeightedDigraph(graph));
        System.out.println("=========================================");
        /*
        6 5
        0: 0-1 7.00000
        1: 1-2 3.00000  0-1 7.00000
        2: 1-2 3.00000  2-4 3.00000
        3: 3-4 2.00000
        4: 3-4 2.00000  4-5 2.00000  2-4 3.00000
        5: 4-5 2.00000
         */
        System.out.println(printEdgeWeightedDigraph(mst(graph)));
        System.out.println("=========================================");
        System.out.println(printEdgeWeightedDigraph(mst1(graph)));

        System.out.println();
        System.out.println("=========================================");
        System.out.println("=========================================");

        Map<String, List<GraphUtils.Edge<String, Double>>> graph1 = createGraph1();
        System.out.println(printEdgeWeightedDigraph(graph1));
        System.out.println("=========================================");
        /*
        7 6
        0: 0-1 2.00000  0-2 3.00000
        1: 0-1 2.00000  1-6 3.00000
        2: 2-4 1.00000  0-2 3.00000
        3: 3-4 5.00000
        4: 2-4 1.00000  3-4 5.00000
        5: 5-6 2.00000
        6: 5-6 2.00000  1-6 3.00000
         */
        System.out.println(printEdgeWeightedDigraph(mst(graph1)));
        System.out.println("=========================================");
        System.out.println(printEdgeWeightedDigraph(mst1(graph1)));
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

    // O(E * log(E)) time | O(E + V) space
    public static Map<String, List<Edge<String, Double>>> mst(Map<String, List<Edge<String, Double>>> graph) {
        Map<String, List<Edge<String, Double>>> mstGraph = new HashMap<>();

        Set<Edge<String, Double>> edges = new HashSet<>();
        for (List<Edge<String, Double>> lst : graph.values()) {
            edges.addAll(lst);
        }

        PriorityQueue<Edge<String, Double>> heap = new PriorityQueue<>(graph.size(), Comparator.comparingDouble(Edge::weight));
        heap.addAll(edges);

        Map<String, String> parents = makeSet(graph);

        while (!heap.isEmpty()) {
            Edge<String, Double> minEdge = heap.remove();
            String from = minEdge.from();
            String to = minEdge.to();

            String pFrom = find(parents, from);
            String pTo = find(parents, to);
            if (!pFrom.equals(pTo)) {
                var newEdge = new Edge<>(from, to, minEdge.weight());
                var fromLst = mstGraph.getOrDefault(from, new ArrayList<>());
                fromLst.add(newEdge);
                mstGraph.put(from, fromLst);
                var toLst = mstGraph.getOrDefault(to, new ArrayList<>());
                toLst.add(newEdge);
                mstGraph.put(to, toLst);

                union(parents, pFrom, pTo);
            }
        }

        return mstGraph;
    }

    private static void union(Map<String, String> parents, String v, String u) {
        String pV = find(parents, v);
        String pU = find(parents, u);
        parents.put(pU, pV);
    }

    private static Map<String, String> makeSet(Map<String, List<Edge<String, Double>>> graph) {
        Map<String, String> parents = new HashMap<>();
        for (String v : graph.keySet()) {
            parents.put(v, v);
        }
        return parents;
    }

    private static String find(Map<String, String> parents, String v) {
        if (parents.get(v).equals(v)) return v;
        else return find(parents, parents.get(v));
    }

    // O(E * log(E)) time | O(E + V) space
    public static Map<String, List<GraphUtils.Edge<String, Double>>> mst1(Map<String, List<Edge<String, Double>>> graph) {
        Map<String, List<GraphUtils.Edge<String, Double>>> mstGraph = new HashMap<>();

        Set<Edge<String, Double>> edges = new HashSet<>();
        for (List<Edge<String, Double>> lst : graph.values()) {
            edges.addAll(lst);
        }
        List<Edge<String, Double>> sorted = new ArrayList<>(edges);
        sorted.sort(Comparator.comparingDouble(Edge::weight));

        Map<String, String> parents = makeSet(graph);

        for (Edge<String, Double> edge : sorted) {
            String from = edge.from();
            String to = edge.to();

            String pFrom = find(parents, from);
            String pTo = find(parents, to);

            if (!pFrom.equals(pTo)) {
                var newEdge = new Edge<>(from, to, edge.weight());
                var fromLst = mstGraph.getOrDefault(from, new ArrayList<>());
                fromLst.add(newEdge);
                mstGraph.put(from, fromLst);
                var toLst = mstGraph.getOrDefault(to, new ArrayList<>());
                toLst.add(newEdge);
                mstGraph.put(to, toLst);
                union(parents, pFrom, pTo);
            }
        }

        return mstGraph;
    }
}
