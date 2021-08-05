package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
//        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath shortestPath = shortestPath(graph, 0);
            System.out.println(shortestPath);

            System.out.println(Arrays.toString(findNegativeWeightCycle(graph, shortestPath)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private static int[] findNegativeWeightCycle(EdgeWeightedDigraph graph, ShortestPath shortestPath) {
        double[] shortest = shortestPath.getShortest();
        int[] pred = shortestPath.getPred();
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
            x = pred[x];
            cnt++;
        }

        v = pred[x];
        int[] cycle = new int[cnt];
        int index = 0;
        cycle[index++] = x;
        while (v != x) {
            cycle[index++] = v;
            v = pred[v];
        }
        return cycle;
    }
}
