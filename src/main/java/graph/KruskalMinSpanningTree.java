package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalMinSpanningTree {
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
        // [5-6 2.00000, 0-2 3.00000, 2-4 1.00000, 0-1 2.00000, 1-6 4.00000, 3-4 5.00000]
        System.out.println("=========================================");
        System.out.println(mst(graph1));
    }

    public static Set<Edge> mst(EdgeWeightedGraph graph) {

        Set<Edge> mst = new HashSet<>();

        PriorityQueue<Edge> heap = new PriorityQueue<>(graph.E(), Comparator.comparing(Edge::weight));
        for (Edge edge : graph.edges()) {
            heap.add(edge);
        }

        int[] parent = makeSet(graph);

        int idx = 0;
        while (idx < graph.V() - 1) {
            Edge minEdge = heap.remove();
            int x = minEdge.either();
            int y = minEdge.other(x);

            int xSet = find(parent, x);
            int ySet = find(parent, y);

            if (xSet != ySet) {
                mst.add(minEdge);
                union(parent, xSet, ySet);
                idx++;
            }
        }
        return mst;
    }

    private static int[] makeSet(EdgeWeightedGraph graph) {
        int[] parent = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            parent[i] = i;
        }
        return parent;
    }

    private static int find(int[] parent, int v) {
        if (parent[v] != v) {
            return find(parent, parent[v]);
        }
        return v;
    }

    private static void union(int[] parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);

        parent[yParent] = xParent;
    }
}
