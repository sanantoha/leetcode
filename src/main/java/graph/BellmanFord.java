package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
//        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
        // ShortestPath{shortest=[-9.0, -20.0, -18.0, -2.0, -11.0], prev=[4, 2, 4, 0, 1]}
        // [4, 1, 2]
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath shortestPath = shortestPath(graph, 0);
            System.out.println(shortestPath);

            System.out.println(findNegativeWeightCycle(graph, shortestPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(V * E) time | O(V) space
    private static ShortestPath shortestPath(EdgeWeightedDigraph graph, int start) {

        double[] shortest = new double[graph.V()];
        int[] pred = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            shortest[i] = Double.POSITIVE_INFINITY;
            pred[i] = -1;
        }
        shortest[start] = 0;


        for (int v = 0; v < graph.V() - 1; v++) {
            for (DirectedEdge edge : graph.edges()) {
                relax(edge, shortest, pred);
            }
        }

        return new ShortestPath(shortest, pred);
    }

    private static void relax(DirectedEdge edge, double[] shortest, int[] pred) {
        double newWeight = edge.weight() + shortest[edge.from()];
        if (shortest[edge.to()] > newWeight) {
            pred[edge.to()] = edge.from();
            shortest[edge.to()] = newWeight;
        }
    }

    // O(E + V) time | O(V) space
    private static List<Integer> findNegativeWeightCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
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
        res.add(v);
        int u = prev[v];
        while (u != v) {
            res.add(u);
            u = prev[u];
        }

        return res;
    }
}
