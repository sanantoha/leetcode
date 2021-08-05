package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DijkstraShortestPaths2 {
    //ShortestPath{shortest=[0.0, 5.0, 8.0, 4.0, 7.0], pred=[-1, 3, 1, 0, 3]}
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(findShortestPath(graph, 0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V * log(V)) time | O(V) space
    public static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {

        double[] shortest = new double[graph.V()];
        int[] prev = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            shortest[i] = Double.POSITIVE_INFINITY;
            prev[i] = -1;
        }
        shortest[start] = 0;

        PriorityQueue<DirectedEdge> queue = new PriorityQueue<>(graph.V(), Comparator.comparing(DirectedEdge::weight));
        queue.add(new DirectedEdge(0, start, 0d));

        while (!queue.isEmpty()) {
            DirectedEdge minEdge = queue.remove();
            for (DirectedEdge edge : graph.adj(minEdge.to())) {
                relax(queue, edge, shortest, prev);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static void relax(Queue<DirectedEdge> queue, DirectedEdge edge, double[] shortest, int[] prev) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (newWeight < shortest[edge.to()]) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
            queue.add(edge);
        }
    }
}
