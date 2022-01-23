package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BellmanFord6 {
    // ShortestPath{shortest=[-9.0, -20.0, -18.0, -2.0, -11.0], prev=[4, 2, 4, 0, 1]}
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath sp = findShortestPath(graph, 0);
            System.out.println(sp);

            System.out.println(findNegativeCycle(graph, sp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(V * E) time | O(V) space
    public static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortests = new double[graph.V()];
        Arrays.fill(shortests, Double.POSITIVE_INFINITY);
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);

        shortests[start] = 0d;

        for (int v = 0; v < graph.V() - 1; v++) {
            for (DirectedEdge edge : graph.edges()) {
                relax(shortests, prev, edge);
            }
        }

        return new ShortestPath(shortests, prev);
    }

    private static void relax(double[] shortests, int[] prev, DirectedEdge edge) {
        double newWeight = shortests[edge.from()] + edge.weight();
        if (shortests[edge.to()] > newWeight) {
            shortests[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
        }
    }

    // O(E + V) time | O(V) space
    public static List<Integer> findNegativeCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
        double[] shortests = sp.getShortest();
        int[] prev = sp.getPrev();
        int v = -1;

        for (DirectedEdge edge : graph.edges()) {
            if (shortests[edge.to()] > shortests[edge.from()] + edge.weight()) {
                v = edge.to();
            }
        }

        if (v == -1) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        res.add(v);

        int u = prev[v];
        while (u != v) {
            res.add(u);
            u = prev[u];
        }
        return res;
    }
}
