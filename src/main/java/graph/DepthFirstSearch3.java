package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch3 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/dfs.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(dfsRec(graph, 0));
            System.out.println(dfsIter(graph, 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> dfsRec(EdgeWeightedDigraph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];
        dfsRecursive(graph, visited, start, result);
        return result;
    }

    private static void dfsRecursive(EdgeWeightedDigraph graph, boolean[] visited, int v, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        for (DirectedEdge edge : graph.adj(v)) {
            if (!visited[edge.to()]) {
                dfsRecursive(graph, visited, edge.to(), result);
            }
        }
    }

    public static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {
        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[graph.V()];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        result.add(start);

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            adjArr[i] = graph.adj(i).iterator();
        }

        while (!stack.isEmpty()) {
            int v = stack.peek();
            Iterator<DirectedEdge> iter = adjArr[v];
            if (iter.hasNext()) {
                DirectedEdge edge = iter.next();
                if (!visited[edge.to()]) {
                    visited[edge.to()] = true;
                    result.add(edge.to());
                    stack.push(edge.to());
                }
            } else {
               stack.pop();
            }
        }

        return result;
    }
}
