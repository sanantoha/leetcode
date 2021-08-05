package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraShortestPaths {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath sp = shortestPath(graph, 0);
            System.out.println(sp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V * log(V)) time | O(V) space
    private static ShortestPath shortestPath(EdgeWeightedDigraph graph, int start) {

        double[] shortest = new double[graph.V()];
        int[] pred = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            shortest[i] = Double.MAX_VALUE;
            pred[i] = -1;
        }
        shortest[0] = 0d;

        PriorityQueue<DirectedEdge> queue = new PriorityQueue<>(graph.V(), Comparator.comparingDouble(DirectedEdge::weight));
        queue.add(new DirectedEdge(0, start, 0d));

        while(!queue.isEmpty()) {
            DirectedEdge minEdge = queue.poll();
            for (DirectedEdge edge : graph.adj(minEdge.to())) {
                relax(queue, edge, shortest, pred);
            }
        }

        return new ShortestPath(shortest, pred);
    }

    private static void relax(PriorityQueue<DirectedEdge> queue, DirectedEdge edge, double[] shortest, int[] pred) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (shortest[edge.to()] > newWeight) {
            shortest[edge.to()] = newWeight;
            pred[edge.to()] = edge.from();
            queue.add(edge);
        }
    }


}
