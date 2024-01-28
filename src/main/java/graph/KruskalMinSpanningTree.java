package graph;

import java.util.*;

public class KruskalMinSpanningTree {

    // O(E * log(E)) time | O(V + E) space
    public static EdgeWeightedGraph mst(EdgeWeightedGraph graph) {

        EdgeWeightedGraph mstGraph = new EdgeWeightedGraph(graph.V());

        // O(E * log(E)) | O(E) space
        PriorityQueue<Edge> heap = new PriorityQueue<>(graph.E(), Comparator.comparing(Edge::weight));
        for (Edge edge : graph.edges()) {
            heap.add(edge);
        }

        // O(V) space
        int[] parent = makeSet(graph);
        int[] ranks = new int[graph.V()];

        while (!heap.isEmpty()) { // O(E)
            Edge minEdge = heap.remove(); // O(log(E))
            int x = minEdge.either();
            int y = minEdge.other(x);

            int xSet = find(parent, x);
            int ySet = find(parent, y);

            if (xSet != ySet) {
                mstGraph.addEdge(new Edge(x, y, minEdge.weight()));
                union(parent, ranks, xSet, ySet);
            }
        }
        return mstGraph;
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

    private static void union(int[] parents, int[] ranks, int pV, int pU) {
        if (ranks[pV] > ranks[pU]) {
            parents[pU] = pV;
        } else if (ranks[pV] < ranks[pU]) {
            parents[pV] = pU;
        } else {
            parents[pU] = pV;
            ranks[pV]++;
        }
    }

    // O(E * log(E)) time | O(E + V) space
    public static EdgeWeightedGraph mst1(EdgeWeightedGraph graph) {
        Edge[] edges = new Edge[graph.E()];
        int i = 0;
        for (Edge edge : graph.edges()) {
            edges[i++] = edge;
        }
        Arrays.sort(edges, Comparator.comparingDouble(Edge::weight));

        int[] parents = makeSet(graph);
        int[] ranks = new int[graph.V()];

        EdgeWeightedGraph mstGraph = new EdgeWeightedGraph(graph.V());

        for (Edge edge : edges) {
            int v = edge.either();
            int u = edge.other(v);

            int vRoot = find(parents, v);
            int uRoot = find(parents, u);
            if (vRoot != uRoot) {
                mstGraph.addEdge(new Edge(v, u, edge.weight()));
                union(parents, ranks, vRoot, uRoot);
            }
        }

        return mstGraph;
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
        /*
        6 5
        0: 0-1 7.00000
        1: 1-2 3.00000  0-1 7.00000
        2: 1-2 3.00000  2-4 3.00000
        3: 3-4 2.00000
        4: 3-4 2.00000  4-5 2.00000  2-4 3.00000
        5: 4-5 2.00000
         */
        System.out.println(mst(graph));
        System.out.println("=========================================");
        System.out.println(mst1(graph));
        System.out.println("=========================================");
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
        System.out.println("=========================================");
        System.out.println(mst(graph1));
        System.out.println("=========================================");
        System.out.println(mst1(graph1));
    }
}
