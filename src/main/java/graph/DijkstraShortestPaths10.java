package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraShortestPaths10 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            ShortestPath sp = findShortestPath(graph, 0);
            System.out.println(sp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // O((E + V) * log(V)) time | O(V) space
    private static ShortestPath findShortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortests = new double[graph.V()];
        Arrays.fill(shortests, Double.POSITIVE_INFINITY);
        int[] prev = new int[graph.V()];
        Arrays.fill(prev, -1);
        shortests[start] = 0d;


        PriorityQueue<DirectedEdge> heap = new PriorityQueue<>(graph.V(), Comparator.comparingDouble(DirectedEdge::weight));
        heap.add(new DirectedEdge(0, 0, 0d));

        while (!heap.isEmpty()) {
            DirectedEdge edge = heap.remove();
            for (DirectedEdge ne : graph.adj(edge.to())) {
                relax(graph, shortests, prev, ne, heap);
            }
        }


        return new ShortestPath(shortests, prev);
    }

    private static void relax(EdgeWeightedDigraph graph, double[] shortests, int[] prev, DirectedEdge edge, PriorityQueue<DirectedEdge> heap) {
        double newWeight = shortests[edge.from()] + edge.weight();

        if (newWeight < shortests[edge.to()]) {
            shortests[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
            heap.add(edge);
        }
    }
}
