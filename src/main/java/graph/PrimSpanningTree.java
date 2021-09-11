package graph;

import java.util.*;

/**
 *
 */
public class PrimSpanningTree {
    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(6);
        graph.addEdge(new Edge(0, 1, 7.0));
        graph.addEdge(new Edge(0, 2, 8.0));
        graph.addEdge(new Edge(1, 2, 3.0));
        graph.addEdge(new Edge(1, 3, 6.0));
        graph.addEdge(new Edge(2, 3, 4.0));
        graph.addEdge(new Edge(2, 4, 3.0));
        graph.addEdge(new Edge(3, 4, 2.0));
        graph.addEdge(new Edge(3, 5, 5.0));
        graph.addEdge(new Edge(4, 5, 2.0));

        System.out.println(graph);
        System.out.println("=========================================");
        // [4-5 2.00000, 0-1 7.00000, 2-4 3.00000, 1-2 3.00000, 3-4 2.00000]
        System.out.println(spanningTree(graph));
        System.out.println("=========================================");
        System.out.println("=========================================");

        EdgeWeightedGraph graph1 = new EdgeWeightedGraph(7);
        graph1.addEdge(new Edge(0, 1, 2.0));
        graph1.addEdge(new Edge(0, 2, 3.0));
        graph1.addEdge(new Edge(0, 3, 7.0));
        graph1.addEdge(new Edge(1, 2, 6.0));
        graph1.addEdge(new Edge(1, 6, 4.0));
        graph1.addEdge(new Edge(2, 4, 1.0));
        graph1.addEdge(new Edge(2, 5, 8.0));
        graph1.addEdge(new Edge(3, 4, 5.0));
        graph1.addEdge(new Edge(4, 5, 4.0));
        graph1.addEdge(new Edge(5, 6, 2.0));

        System.out.println(graph1);
        // [5-6 2.00000, 0-2 3.00000, 2-4 1.00000, 0-1 2.00000, 1-6 4.00000, 3-4 5.00000]
        System.out.println("=========================================");
        System.out.println(spanningTree(graph1));
    }

    public static Set<Edge> spanningTree(EdgeWeightedGraph graph) {
        Set<Edge> addedEdges = new HashSet<>();
        Set<Integer> addedVertices = new HashSet<>();

        PriorityQueue<Edge> heap = new PriorityQueue<>(graph.V(), Comparator.comparing(Edge::weight));
        // start from node 0 (we can choose any node)
        int start = 0;
        for (Edge edge : graph.adj(start)) {
            heap.add(edge);
        }

        while (!heap.isEmpty()) {
            Edge minEdge = heap.remove();
            int from = minEdge.either();
            int to = minEdge.other(from);

            if (!addedVertices.contains(from)) {
                addedEdges.add(minEdge);
                addedVertices.add(from);
                for (Edge edge : graph.adj(from)) {
                    heap.add(edge);
                }
            }

            if (!addedVertices.contains(to)) {
                addedEdges.add(minEdge);
                addedVertices.add(to);
                for (Edge edge : graph.adj(to)) {
                    heap.add(edge);
                }
            }
        }

        return addedEdges;
    }
}
