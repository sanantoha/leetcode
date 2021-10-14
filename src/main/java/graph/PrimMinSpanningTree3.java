package graph;

import java.util.*;

public class PrimMinSpanningTree3 {

    static class Pair {
        Edge edge;
        int key;

        public Pair(Edge edge, int key) {
            this.edge = edge;
            this.key = key;
        }
    }

    // O(E * log(V)) time | O(V) space
    public static Set<Edge> mst(EdgeWeightedGraph graph) {
        Set<Edge> mst = new HashSet<>();

        boolean[] visible = new boolean[graph.V()];
        int start = 0;
        visible[start] = true;

        PriorityQueue<Pair> pq = new PriorityQueue<>(graph.V(), Comparator.comparing(x -> x.edge.weight()));
        for (Edge edge : graph.adj(start)) {
            pq.add(new Pair(edge, start));
        }

        int inTree = 1;

        while (!pq.isEmpty() && inTree < graph.V()) {
            Pair pair = pq.remove();
            Edge minEdge = pair.edge;
            int from = pair.key;
            int to = minEdge.other(from);

            if (visible[to]) continue;

            visible[to] = true;
            mst.add(minEdge);
            inTree++;

            for (Edge edge : graph.adj(to)) {
                pq.add(new Pair(edge, to));
            }
        }

        if (inTree < graph.V()) {
            return Collections.emptySet();
        }

        return mst;
    }

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
        System.out.println(mst(graph));

        System.out.println();
        System.out.println("=========================================");
        System.out.println("=========================================");

        EdgeWeightedGraph graph1 = new EdgeWeightedGraph(7);
        graph1.addEdge(new Edge(0, 1, 2.0));
        graph1.addEdge(new Edge(0, 2, 3.0));
        graph1.addEdge(new Edge(0, 3, 7.0));
        graph1.addEdge(new Edge(1, 2, 6.0));
        graph1.addEdge(new Edge(1, 6, 3.0));
        graph1.addEdge(new Edge(2, 4, 1.0));
        graph1.addEdge(new Edge(2, 5, 8.0));
        graph1.addEdge(new Edge(3, 4, 5.0));
        graph1.addEdge(new Edge(4, 5, 4.0));
        graph1.addEdge(new Edge(5, 6, 2.0));

        System.out.println(graph1);
        // [5-6 2.00000, 0-2 3.00000, 2-4 1.00000, 0-1 2.00000, 1-6 3.00000, 3-4 5.00000]
        System.out.println("=========================================");
        System.out.println(mst(graph1));
    }
}
