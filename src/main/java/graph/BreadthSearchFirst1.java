package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthSearchFirst1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(bfs(graph, 0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> bfs(EdgeWeightedDigraph graph, int i) {
        List<Integer> ans = new ArrayList<>(graph.V());
        boolean[] visited = new boolean[graph.V()];

        visited[i] = true;
        ans.add(i);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (DirectedEdge edge : graph.adj(v)) {
                int to = edge.to();
                if (!visited[to]) {
                    queue.add(to);
                    ans.add(to);
                    visited[to] = true;
                }
            }
        }


        return ans;
    }
}
