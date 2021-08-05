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

public class DepthFirstSearch1 {
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

    private static List<Integer> dfsRec(EdgeWeightedDigraph graph, int i) {
        boolean[] visited = new boolean[graph.V()];
        List<Integer> ans = new ArrayList<>(graph.V());

        dfsRec(graph, visited, ans, i);

        return ans;
    }

    private static void dfsRec(EdgeWeightedDigraph graph, boolean[] visited, List<Integer> ans, int i) {
        visited[i] = true;
        ans.add(i);
        for (DirectedEdge edge : graph.adj(i)) {
            int to = edge.to();
            if (!visited[to]) {
                dfsRec(graph, visited, ans, to);
            }
        }
    }

    private static List<Integer> dfsIter(EdgeWeightedDigraph graph, int i) {
        List<Integer> ans = new ArrayList<>(graph.V());
        boolean[] visited = new boolean[graph.V()];

        visited[i] = true;
        ans.add(i);

        Iterator<DirectedEdge>[] adjArr = new Iterator[graph.V()];
        for (int j = 0; j < graph.V(); j++) {
            adjArr[j] = graph.adj(j).iterator();
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(i);

        while (!stack.isEmpty()) {
            Integer v = stack.peek();
            if (adjArr[v].hasNext()) {
                DirectedEdge edge = adjArr[v].next();
                int to = edge.to();
                if (!visited[to]) {
                    ans.add(to);
                    visited[to] = true;
                    stack.push(to);
                }
            }  else {
                stack.pop();
            }

        }

        return ans;
    }
}
