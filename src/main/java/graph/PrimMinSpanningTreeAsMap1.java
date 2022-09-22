package graph;

import java.util.*;

import static graph.GraphUtils.printEdgeWeightedDigraph;
import static graph.GraphUtils.Edge;
import static graph.GraphUtils.Pair;

public class PrimMinSpanningTreeAsMap1 {

    public static void main(String[] args) {
        Map<String, List<GraphUtils.Edge<String, Double>>> graph = createGraph();
        System.out.println(printEdgeWeightedDigraph(graph));
        System.out.println("=========================================");
        // [4-5 2.00000, 0-1 7.00000, 2-4 3.00000, 1-2 3.00000, 3-4 2.00000]
        System.out.println(mst(graph));

        System.out.println();
        System.out.println("=========================================");
        System.out.println("=========================================");

        Map<String, List<GraphUtils.Edge<String, Double>>> graph1 = createGraph1();
        System.out.println(printEdgeWeightedDigraph(graph1));
        System.out.println("=========================================");
        // // [5-6 2.00000, 0-2 3.00000, 2-4 1.00000, 0-1 2.00000, 1-6 3.00000, 3-4 5.00000]
        System.out.println(mst(graph1));
    }

    private static Map<String, List<GraphUtils.Edge<String, Double>>> createGraph1() {
        Map<String, List<GraphUtils.Edge<String, Double>>> graph = new HashMap<>();

        GraphUtils.Edge<String, Double> edge01 = new GraphUtils.Edge<>("0", "1", 2.0);
        GraphUtils.Edge<String, Double> edge02 = new GraphUtils.Edge<>("0", "2", 3.0);
        GraphUtils.Edge<String, Double> edge03 = new GraphUtils.Edge<>("0", "3", 7.0);

        GraphUtils.Edge<String, Double> edge12 = new GraphUtils.Edge<>("1", "2", 6.0);
        GraphUtils.Edge<String, Double> edge16 = new GraphUtils.Edge<>("1", "6", 3.0);

        GraphUtils.Edge<String, Double> edge24 = new GraphUtils.Edge<>("2", "4", 1.0);
        GraphUtils.Edge<String, Double> edge25 = new GraphUtils.Edge<>("2", "5", 8.0);

        GraphUtils.Edge<String, Double> edge34 = new GraphUtils.Edge<>("3", "4", 5.0);

        GraphUtils.Edge<String, Double> edge45 = new GraphUtils.Edge<>("4", "5", 4.0);

        GraphUtils.Edge<String, Double> edge56 = new GraphUtils.Edge<>("5", "6", 2.0);

        graph.put("0", List.of(edge01, edge02, edge03));
        graph.put("1", List.of(edge01, edge12, edge16));
        graph.put("2", List.of(edge02, edge12, edge24, edge25));
        graph.put("3", List.of(edge03, edge34));
        graph.put("4", List.of(edge24, edge34, edge45));
        graph.put("5", List.of(edge25, edge45, edge56));
        graph.put("6", List.of(edge16, edge56));

        return graph;
    }

    private static Map<String, List<GraphUtils.Edge<String, Double>>> createGraph() {
        Map<String, List<GraphUtils.Edge<String, Double>>> graph = new HashMap<>();

        GraphUtils.Edge<String, Double> edge01 = new GraphUtils.Edge<>("0", "1", 7.0);
        GraphUtils.Edge<String, Double> edge02 = new GraphUtils.Edge<>("0", "2", 8.0);

        GraphUtils.Edge<String, Double> edge12 = new GraphUtils.Edge<>("1", "2", 3.0);
        GraphUtils.Edge<String, Double> edge13 = new GraphUtils.Edge<>("1", "3", 6.0);

        GraphUtils.Edge<String, Double> edge23 = new GraphUtils.Edge<>("2", "3", 4.0);
        GraphUtils.Edge<String, Double> edge24 = new GraphUtils.Edge<>("2", "4", 3.0);

        GraphUtils.Edge<String, Double> edge34 = new GraphUtils.Edge<>("3", "4", 2.0);
        GraphUtils.Edge<String, Double> edge35 = new GraphUtils.Edge<>("3", "5", 5.0);

        GraphUtils.Edge<String, Double> edge45 = new GraphUtils.Edge<>("4", "5", 2.0);

        graph.put("0", List.of(edge01, edge02));
        graph.put("1", List.of(edge01, edge12, edge13));
        graph.put("2", List.of(edge02, edge12, edge23, edge24));
        graph.put("3", List.of(edge13, edge23, edge34, edge35));
        graph.put("4", List.of(edge24, edge34, edge45));
        graph.put("5", List.of(edge35, edge45));
        return graph;
    }

    public static Set<Edge<String, Double>> mst(Map<String, List<Edge<String, Double>>> graph) {
        return null;
    }
}
