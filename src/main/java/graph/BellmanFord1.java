package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath sp = findShortestPath(graph, 0);
            System.out.println(sp);
            System.out.println(Arrays.toString(findNegativeWeightCycle(graph, sp)));
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
        prev[start] = -1;

        for (int i = 0; i < graph.V() - 1; i++) {
            for (DirectedEdge edge : graph.edges()) {
                relax(shortest, prev, edge);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static int[] findNegativeWeightCycle(EdgeWeightedDigraph graph, ShortestPath shortestPath) {
        double[] shortest = shortestPath.getShortest();
        int[] prev = shortestPath.getPrev();
        int v = -1;

        for (DirectedEdge edge : graph.edges()) {
            if (shortest[edge.to()] > shortest[edge.from()] + edge.weight()) {
                v = edge.to();
            }
        }

        if (v == -1) return new int[0];

        boolean[] visited = new boolean[graph.V()];
        int x = v;
        int cnt = 0;
        while (!visited[x]) {
            visited[x] = true;
            x = prev[x];
            cnt++;
        }

        v = prev[x];
        int[] cycle = new int[cnt];
        Arrays.fill(cycle, -1);
        int idx = 0;
        cycle[idx++] = x;
        while (x != v) {
            cycle[idx++] = v;
            v = prev[v];
        }

        return cycle;
    }

    private static void relax(double[] shortest, int[] prev, DirectedEdge edge) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (shortest[edge.to()] > newWeight) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
        }
    }
}
