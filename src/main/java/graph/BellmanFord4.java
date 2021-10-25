package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BellmanFord4 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);

            ShortestPath sp = findShortestPath(graph, 0);
            System.out.println(sp);

            int[] cycle = findNegativeCycle(graph, sp);
            System.out.println(Arrays.toString(cycle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(V * E) time | O(V) space
    public static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortest = new double[graph.V()];
        Arrays.fill(shortest, Double.POSITIVE_INFINITY);
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);
        shortest[start] = 0d;

        for (int i = 0; i < graph.V() - 1; i++) {
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

    public static int[] findNegativeCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
        double[] shortest = sp.getShortest();
        int[] prev = sp.getPrev();

        int v = -1;

        for (DirectedEdge edge : graph.edges()) {
            if (shortest[edge.to()] > shortest[edge.from()] + edge.weight()) {
                v = edge.to();
            }
        }

        if (v == -1) return new int[0];

        List<Integer> cycle = new ArrayList<>();
        cycle.add(v);
        int x = prev[v];
        while (x != v) {
            cycle.add(x);
            x = prev[x];
        }

        return cycle.stream().mapToInt(Integer::intValue).toArray();
    }
}
