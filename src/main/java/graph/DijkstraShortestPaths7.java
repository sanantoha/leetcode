package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraShortestPaths7 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath sp = shortestPath(graph, 0);
            System.out.println(sp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O((E + V) * log(V)) time | O(V) space
    public static ShortestPath shortestPath(EdgeWeightedDigraph graph, int start) {

        double[] shortest = new double[graph.V()];
        Arrays.fill(shortest, Double.POSITIVE_INFINITY);
        shortest[start] = 0d;
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);

        PriorityQueue<DirectedEdge> heap = new PriorityQueue<>(graph.V(), Comparator.comparingDouble(DirectedEdge::weight));
        heap.add(new DirectedEdge(0, 0, 0d));

        while (!heap.isEmpty()) {
            DirectedEdge minEdge = heap.remove();
            for (DirectedEdge edge : graph.adj(minEdge.to())) {
                relax(shortest, prev, edge, heap);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static void relax(double[] shortest, int[] prev, DirectedEdge edge, Queue<DirectedEdge> heap) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (newWeight < shortest[edge.to()]) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
            heap.add(edge);
        }
    }
}
