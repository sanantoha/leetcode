package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraShortestPaths8 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(shortestPaths(graph, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ShortestPath{shortest=[0.0, 5.0, 8.0, 4.0, 7.0], pred=[-1, 3, 1, 0, 3]}
    // O((E + V) * log(V)) time | O(V) space
    public static ShortestPath shortestPaths(EdgeWeightedDigraph graph, int start) {

        double[] shortests = new double[graph.V()];
        Arrays.fill(shortests, Double.POSITIVE_INFINITY);
        shortests[start] = 0d;
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);

        PriorityQueue<DirectedEdge> heap =
                new PriorityQueue<>(graph.V(), Comparator.comparingDouble(DirectedEdge::weight));
        heap.add(new DirectedEdge(0, 0, 0d));

        while (!heap.isEmpty()) {
            DirectedEdge minEdge = heap.remove();
            for (DirectedEdge edge : graph.adj(minEdge.to())) {
                relax(shortests, prev, edge, heap);
            }
        }

        return new ShortestPath(shortests, prev);
    }

    private static void relax(double[] shortests, int[] prev, DirectedEdge edge, Queue<DirectedEdge> heap) {
        double newWeight = shortests[edge.from()] + edge.weight();
        if (shortests[edge.to()] > newWeight) {
            shortests[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
            heap.add(edge);
        }
    }
}
