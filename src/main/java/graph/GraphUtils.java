package graph;

import java.util.*;

public class GraphUtils {

    static final class Pair<T1, T2> {
        final T1 t1;
        final T2 t2;

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        T1 getOne() {
            return t1;
        }

        T2 getTwo() {
            return t2;
        }

        @Override
        public String toString() {
            return "{" +
                    "t1=" + t1 +
                    ", t2=" + t2 +
                    '}';
        }
    }

    public static Map<String, List<Pair<String, Double>>> edgeWeightedDigraph(Scanner in) {
        Map<String, List<Pair<String, Double>>> map = new HashMap<>();
        in.nextInt();
        int E = in.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weight = in.nextDouble();

            String key = String.valueOf(v);

            List<Pair<String, Double>> lst = map.getOrDefault(key, new ArrayList<>());
            lst.add(new Pair<>(String.valueOf(w), weight));
            map.put(key, lst);
        }

        return map;
    }

    /*
    5 10
0: 0->1  6.00  0->3  4.00
1: 1->3  2.00  1->2  3.00
2: 2->4  4.00
3: 3->1  1.00  3->2  9.00  3->4  3.00
4: 4->2  5.00  4->0  7.00
     */
    public static String printEdgeWeightedDigraph(Map<String, List<Pair<String, Double>>> graph) {
        StringBuilder res = new StringBuilder();
        res.append(graph.size()).append(" ");
        int edge = 0;
        StringBuilder subRes = new StringBuilder();
        for (Map.Entry<String, List<Pair<String, Double>>> entry : graph.entrySet()) {
            String v = entry.getKey();
            List<Pair<String, Double>> lst = entry.getValue();
            edge += lst.size();
            subRes.append(v).append(": ");
            for (Pair<String, Double> p : lst) {
                subRes.append(v).append("->").append(p.t1).append(" ").append(p.t2).append("  ");
            }
            subRes.append("\n");
        }
        res.append(edge).append("\n");
        res.append(subRes);
        return res.toString();
    }


}
