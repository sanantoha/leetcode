package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord3 {
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

    private static int[] findNegativeWeightCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
        double[] shortest = sp.getShortest();
        int[] prev = sp.getPrev();

        int v = -1;
        for (DirectedEdge edge : graph.edges()) {
            if (shortest[edge.to()] < shortest[edge.from()] + edge.weight()) {
                v = prev[edge.to()];
            }
        }

        if (v == -1) return new int[0];

        boolean[] visited = new boolean[graph.V()];
        int cnt = 0;
        while (!visited[v]) {
            visited[v] = true;
            v = prev[v];
            cnt++;
        }

        int[] cycle = new int[cnt];
        Arrays.fill(cycle, - 1);
        int idx = 0;
        int x = prev[v];
        cycle[idx++] = v;
        while (x != v) {
            cycle[idx++] = x;
            x = prev[x];
        }

        return cycle;
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
}
