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

public class DepthFirstSearch {
    public static void main(String[] args) {
        try(FileReader read = new FileReader("src/main/java/graph/dfs.txt")) {
            Scanner scanner = new Scanner(read);

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

    // O(V + E) time | O(V) space
    private static List<Integer> dfsRec(EdgeWeightedDigraph graph, int start) {
        List<Integer> ans = new ArrayList<>(graph.V());

        boolean[] visited = new boolean[graph.V()];

        dfsRecursive(graph, visited, ans, start);
        return ans;
    }

    private static void dfsRecursive(EdgeWeightedDigraph graph, boolean[] visited, List<Integer> ans, int vertex) {
        visited[vertex] = true;
        ans.add(vertex);
        for (DirectedEdge edge : graph.adj(vertex)) {
            if (!visited[edge.to()]) {
                dfsRecursive(graph, visited, ans, edge.to());
            }
        }
    }

    // O(V + E) time | O(V) space
    public static List<Integer> dfsIter(EdgeWeightedDigraph graph,  int start) {
        List<Integer> ans = new ArrayList<>(graph.V());

        boolean[] visited = new boolean[graph.V()];

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            adjArr[v] = graph.adj(v).iterator();
        }

        visited[start] = true;
        ans.add(start);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int vertex = stack.peek();
            if (adjArr[vertex].hasNext()) {
                DirectedEdge edge = adjArr[vertex].next();
                int to = edge.to();
                if (!visited[to]) {
                    visited[to] = true;
                    ans.add(to);
                    stack.push(to);
                }
            } else {
                stack.pop();
            }
        }

        return ans;
    }
}
