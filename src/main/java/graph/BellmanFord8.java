package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BellmanFord8 {

    // ShortestPath{shortest=[-9.0, -20.0, -18.0, -2.0, -11.0], prev=[4, 2, 4, 0, 1]}
    public static void main(String[] args) {
        String path = "src/main/java/graph/bellmanFord.txt";

        try (FileReader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);

            ShortestPath sp = findShortestPath(graph, 0);
            System.out.println(sp);

            List<Integer> nc = findNegativeCycle(graph, sp);
            System.out.println(nc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(V * E) time | O(V) space
    public static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortest = new double[graph.V()];
        Arrays.fill(shortest, Double.POSITIVE_INFINITY);
        shortest[start] = 0d;
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);

        for (int v = 0; v < graph.V() - 1; v++) {
            for (DirectedEdge edge : graph.edges()) {
                relax(shortest, prev, edge);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static void relax(double[] shortest, int[] prev, DirectedEdge edge) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (newWeight < shortest[edge.to()]) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
        }
    }

    // O(E + V) time | O(V) space
    private static List<Integer> findNegativeCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
        double[] shortest = sp.getShortest();
        int[] prev = sp.getPrev();

        int v = -1;
        for (DirectedEdge edge : graph.edges()) {
            if (shortest[edge.from()] + edge.weight() < shortest[edge.to()]) {
                v = edge.to();
            }
        }

        if (v == -1) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        int u = prev[v];
        res.add(v);
        while (u != v) {
            res.add(u);
            u = prev[u];
        }

        return res;
    }
}
