package graph;

import java.util.*;

/**
 *
 */
public class PrimMinSpanningTree {
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

    }

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // O(E * log(V)) time | O(V) space
    public static EdgeWeightedGraph mst(EdgeWeightedGraph graph) {
        EdgeWeightedGraph mstGraph = new EdgeWeightedGraph(graph.V());
        int start = 0;

        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;
        int inTree = 1;

        PriorityQueue<Pair<Edge, Integer>> heap = new PriorityQueue<>(graph.V(), Comparator.comparing(x -> x.getKey().weight()));
        for (Edge edge : graph.adj(start)) {
            heap.add(new Pair(edge, start));
        }

        while (!heap.isEmpty() && inTree < graph.V()) {
            Pair<Edge, Integer> pair = heap.remove();
            Edge minEdge = pair.getKey();
            int to = minEdge.other(pair.getValue());

            if (visited[to]) continue;

            inTree++;
            visited[to] = true;
            mstGraph.addEdge(new Edge(minEdge.either(), minEdge.other(minEdge.either()), minEdge.weight()));

            for (Edge edge : graph.adj(to)) {
                heap.add(new Pair(edge, to));
            }
        }
        if (inTree < graph.V()) {
            return null;
        }

        return mstGraph;
    }
}
