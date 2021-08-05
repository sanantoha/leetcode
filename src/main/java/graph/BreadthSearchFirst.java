package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadthSearchFirst {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);

            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            System.out.println(bfs(graph, 2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> bfs(EdgeWeightedDigraph graph, int start) {

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.V()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for (DirectedEdge edge : graph.adj(vertex)) {
                int to = edge.to();
                if (!visited[to]) {
                    visited[to] = true;
                    ans.add(to);
                    queue.add(to);
                }
            }
        }

        return ans;
    }
}
