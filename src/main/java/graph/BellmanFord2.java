package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord2 {
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

    public static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortest = new double[graph.V()];
        int[] prev = new int[graph.V()];
        Arrays.fill(shortest, Double.POSITIVE_INFINITY);
        Arrays.fill(prev, -1);
        shortest[start] = 0;

        for (int i = 0; i < graph.V() - 1; i++) {
            for (DirectedEdge edge : graph.edges()) {
                relax(edge, shortest, prev);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static void relax(DirectedEdge edge, double[] shortest, int[] prev) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (shortest[edge.to()] > newWeight) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
        }
    }

    public static int[] findNegativeWeightCycle(EdgeWeightedDigraph graph, ShortestPath sp) {
        double[] shortest = sp.getShortest();
        int[] prev = sp.getPrev();
        int v = -1;
        for (DirectedEdge edge : graph.edges()) {
            if (shortest[edge.to()] > shortest[edge.from()] + edge.weight()) {
                v = edge.to();
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
        Arrays.fill(cycle, -1);
        int x = prev[v];
        int idx = 0;
        cycle[idx++] = v;
        while (x != v) {
            cycle[idx++] = x;
            x = prev[x];
        }

        return cycle;
    }
}
