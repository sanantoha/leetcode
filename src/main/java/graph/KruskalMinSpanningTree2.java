package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalMinSpanningTree2 {

    // O(V * log(E) + E * log(E)) time | O(E + V) space
    public static Set<Edge> mst(EdgeWeightedGraph graph) {
        Set<Edge> res = new HashSet<>();

        int[] parents = makeSet(graph);

        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.E(), Comparator.comparing(Edge::weight));
        for (Edge edge : graph.edges()) {
            pq.add(edge);
        }

        int cnt = 0;
        while (cnt < graph.V() - 1) {
            Edge minEdge = pq.remove();
            int from = minEdge.either();
            int to = minEdge.other(from);

            int fromParent = find(parents, from);
            int toParent = find(parents, to);
            if (fromParent != toParent) {
                union(parents, fromParent, toParent);
                res.add(minEdge);
                cnt++;
            }
        }

        return res;
    }

    private static void union(int[] parents, int v, int u) {
        int vParent = find(parents, v);
        int uParent = find(parents, u);
        parents[uParent] = vParent;
    }

    private static int find(int[] parents, int v) {
        if (parents[v] != v) {
            return find(parents, parents[v]);
        }
        return v;
    }

    private static int[] makeSet(EdgeWeightedGraph graph) {
        int[] parents = new int[graph.V()];
        for (int v = 0 ; v < graph.V(); v++) {
            parents[v] = v;
        }
        return parents;
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
