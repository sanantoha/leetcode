package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static graph.GraphUtils.Edge;

public class DepthFirstSearchAsMap {
    public static void main(String[] args) {
        String path = "src/main/java/graph/dfs.txt";
        try (FileReader reader = new FileReader(path)) {
            Scanner in = new Scanner(reader);
            var graph = GraphUtils.edgeWeightedDigraph(in);
            System.out.println(GraphUtils.printEdgeWeightedDigraph(graph));
            String startVertex = "0";
            System.out.println(dfsRec(graph, startVertex));
            System.out.println(dfsIter(graph, startVertex));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // O(E + V) time | O(V) space
    private static List<String> dfsRec(Map<String, List<Edge<String, Double>>> graph, String start) {
        if (graph == null) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfsRecursion(graph, visited, start, res);
        return res;
    }

    private static void dfsRecursion(Map<String, List<Edge<String, Double>>> graph,
                                     Set<String> visited,
                                     String v,
                                     List<String> res) {
        if (visited.contains(v)) return;
        visited.add(v);
        res.add(v);
        for (Edge<String, Double> edge : graph.getOrDefault(v, new ArrayList<>())) {
            dfsRecursion(graph, visited, edge.to(), res);
        }
    }


    // O(E + V) time | O(V) space
    private static List<String> dfsIter(Map<String, List<Edge<String, Double>>> graph, String start) {
        if (graph == null) return Collections.emptyList();

        List<String> res = new ArrayList<>();

        Deque<String> stack = new LinkedList<>();
        stack.push(start);

        Set<String> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            String v = stack.pop();
            if (visited.contains(v)) continue;
            visited.add(v);
            res.add(v);

            List<Edge<String, Double>> adj = graph.getOrDefault(v, new ArrayList<>());
            Collections.reverse(adj);
            for (Edge<String, Double> edge : adj) {
                String to = edge.to();
                stack.push(to);
            }
        }

        return res;
    }
}
