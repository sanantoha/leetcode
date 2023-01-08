package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearch {
    public static void main(String[] args) {
        try(FileReader read = new FileReader("src/main/java/graph/dfs.txt")) {
            Scanner scanner = new Scanner(read);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(dfsRec(graph, 0));
            System.out.println(dfsIter(graph, 0));

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
        List<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[graph.V()];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (visited[v]) continue;
            visited[v] = true;
            res.add(v);

            List<DirectedEdge> lst = new ArrayList<>();
            graph.adj(v).forEach(lst::add);
            Collections.reverse(lst);
            for (DirectedEdge edge : lst) {
                stack.push(edge.to());
            }
        }

        return res;
    }
}
