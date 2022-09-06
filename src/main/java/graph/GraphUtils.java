package graph;

import java.util.*;

public class GraphUtils {

    static final class Pair<T1, T2> {
        private T1 t1;
        private T2 t2;

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public T1 getT1() {
            return t1;
        }

        public T2 getT2() {
            return t2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "t1=" + t1 +
                    ", t2=" + t2 +
                    '}';
        }
    }

    static final class Edge<T, W> {
        private final T from;
        private final T to;
        private final W weight;

        public Edge(T from, T to, W weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        T from() {
            return from;
        }

        T to() {
            return to;
        }

        T other(T v) {
            if (from.equals(v)) return to;
            else if (to.equals(v)) return from;
            else throw new IllegalStateException("Illegal endpoint");
        }

        W weight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static Map<String, List<Edge<String, Double>>> edgeWeightedDigraph(Scanner in) {
        Map<String, List<Edge<String, Double>>> map = new HashMap<>();
        in.nextInt();
        int E = in.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weight = in.nextDouble();

            String key = String.valueOf(v);

            List<Edge<String, Double>> lst = map.getOrDefault(key, new ArrayList<>());
            lst.add(new Edge<>(String.valueOf(v), String.valueOf(w), weight));
            map.put(key, lst);
        }

        return map;
    }

    public static String printEdgeWeightedDigraph(Map<String, List<Edge<String, Double>>> graph) {
        StringBuilder res = new StringBuilder();
        res.append(graph.size()).append(" ");
        Set<Edge<String, Double>> edges = new HashSet<>();
        StringBuilder subRes = new StringBuilder();
        for (Map.Entry<String, List<Edge<String, Double>>> entry : graph.entrySet()) {
            String v = entry.getKey();
            List<Edge<String, Double>> lst = entry.getValue();
            edges.addAll(lst);
            subRes.append(v).append(": ");
            for (Edge<String, Double> edge : lst) {
                subRes.append(edge.from()).append("->").append(edge.to()).append(" ").append(edge.weight()).append("  ");
            }
            subRes.append("\n");
        }
        res.append(edges.size()).append("\n");
        res.append(subRes);
        return res.toString();
    }


}
