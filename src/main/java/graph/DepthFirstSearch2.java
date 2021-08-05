package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DepthFirstSearch2 {
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

    private static List<Integer> dfsIter(EdgeWeightedDigraph graph, int start) {

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];
        result.add(start);
        visited[start] = true;

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            adjArr[v] = graph.adj(v).iterator();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adjArr[v].hasNext()) {
                DirectedEdge edge = adjArr[v].next();
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

    private static List<Integer> dfsRec(EdgeWeightedDigraph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];

        dfsRecursive(graph, visited, result, start);

        return result;
    }

    private static void dfsRecursive(EdgeWeightedDigraph graph, boolean[] visited, List<Integer> result, int v) {
        visited[v] = true;
        result.add(v);
        for (DirectedEdge edge : graph.adj(v)) {
            if (!visited[edge.to()]) {
                dfsRecursive(graph, visited, result, edge.to());
            }
        }
    }
}
