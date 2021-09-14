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
        // [4-5 2.00000, 0-1 7.00000, 2-4 3.00000, 1-2 3.00000, 3-4 2.00000]
        System.out.println(mst(graph));
        System.out.println(mst1(graph));

//        ResultSet[] resultSets = mst1(graph);
//        printMST(resultSets, graph.V());

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
        // [2-4 1.00000, 1-6 3.00000, 5-6 2.00000, 0-1 2.00000, 0-2 3.00000, 3-4 5.00000]
        System.out.println("=========================================");
        System.out.println(mst(graph1));

    }

    public static void printMST(ResultSet[] resultSet, int vertices){
        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i <  vertices; i++) {
            System.out.println("Edge: " + i + " – " + resultSet[i].parent +
                    " key: " + resultSet[i].weight);
            total_min_weight += resultSet[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }

    static class ResultSet {
        int parent;
        double weight;

        @Override
        public String toString() {
            return "ResultSet{" +
                    "parent=" + parent +
                    ", weight=" + weight +
                    '}';
        }
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

    public static Set<Edge> mst(EdgeWeightedGraph graph) {
        Set<Edge> res = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Edge> heap = new PriorityQueue<>(graph.V(), Comparator.comparing(Edge::weight));
        int start = 0;
        for (Edge edge : graph.adj(start)) {
            heap.add(edge);
        }

        while (!heap.isEmpty()) {
            Edge minEdge = heap.remove();
            int from = minEdge.either();
            int to = minEdge.other(from);

            if (!visited.contains(from)) {
                res.add(minEdge);
                visited.add(from);
            }

            if (!visited.contains(to)) {
                res.add(minEdge);
                visited.add(to);
                for (Edge edge : graph.adj(to)) {
                    heap.add(edge);
                }
            }
        }

        return res;
    }

    public static List<Edge> mst1(EdgeWeightedGraph graph) {
//        Set<Edge> res = new HashSet<>();
        List<Edge> res = new ArrayList<>();
        int start = 0;

        boolean[] visited = new boolean[graph.V()];
        visited[start] = true;
        int inTree = 1;

        PriorityQueue<Edge> heap = new PriorityQueue<>(graph.V(), Comparator.comparing(Edge::weight));
        for (Edge edge : graph.adj(start)) {
            heap.add(edge);
        }

        while (!heap.isEmpty() && inTree < graph.V()) {
            Edge minEdge = heap.remove();
            int to = minEdge.other(minEdge.either());

            if (visited[to]) continue;

            inTree++;
            visited[to] = true;
            res.add(minEdge);

            for (Edge edge : graph.adj(to)) {
                if (!visited[edge.other(edge.either())]) heap.add(edge);
            }
        }
        if (inTree < graph.V()) {
            return Collections.emptyList();
        }

        return res;
    }

    public static ResultSet[] mst2(EdgeWeightedGraph graph) {
        boolean[] mst = new boolean[graph.V()];
        ResultSet[] resultSets = new ResultSet[graph.V()];
        for (int i = 0; i < resultSets.length; i++) {
            resultSets[i] = new ResultSet();
        }
        double[] key = new double[graph.V()];

        Arrays.fill(key, Double.POSITIVE_INFINITY);

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(graph.V(), Comparator.comparing(Pair::getKey));

        key[0] = 0;
        Pair<Double, Integer> p0 = new Pair<>(key[0], 0);
        pq.add(p0);
        resultSets[0].parent = -1;

        while (!pq.isEmpty()) {
            Pair<Double, Integer> pair = pq.remove();

            int v = pair.getValue();
            mst[v] = true;

            for (Edge edge : graph.adj(v)) {
                int destination = edge.other(edge.either());
                if (!mst[destination]) {
                    double newKey = edge.weight();
                    if (key[destination] > newKey) {
                        Pair<Double, Integer> p = new Pair<>(newKey, destination);
                        pq.add(p);
                        resultSets[destination].parent = v;
                        resultSets[destination].weight = newKey;
                        key[destination] = newKey;
                    }
                }
            }
        }

        return resultSets;
    }
}
