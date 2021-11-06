package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraShortestPaths5 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dijkstraShortestPath.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(shortestPath(graph, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ShortestPath{shortest=[0.0, 5.0, 8.0, 4.0, 7.0], pred=[-1, 3, 1, 0, 3]}
    // O((E + V) * log(V)) time | O(V) space
    private static ShortestPath shortestPath(EdgeWeightedDigraph graph, int start) {
        double[] shortest = new double[graph.V()];
        int[] prev = new int[graph.V()];
        Arrays.fill(shortest, Double.POSITIVE_INFINITY);
        Arrays.fill(prev, -1);
        shortest[start] = 0d;

        PriorityQueue<DirectedEdge> heap = new PriorityQueue<>(graph.V(), Comparator.comparing(DirectedEdge::weight));
        heap.add(new DirectedEdge(0, start, 0d));

        while (!heap.isEmpty()) {
            DirectedEdge minEdge = heap.remove();
            for (DirectedEdge edge : graph.adj(minEdge.to())) {
                relax(edge, shortest, prev, heap);
            }
        }

        return new ShortestPath(shortest, prev);
    }

    private static void relax(DirectedEdge edge, double[] shortest, int[] prev, Queue<DirectedEdge> heap) {
        double newWeight = shortest[edge.from()] + edge.weight();
        if (newWeight < shortest[edge.to()]) {
            shortest[edge.to()] = newWeight;
            prev[edge.to()] = edge.from();
            heap.add(edge);
        }
    }
}
