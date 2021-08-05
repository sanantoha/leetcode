package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class    TopologicalSortDFS {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/digraph.txt")) {
            Scanner scanner = new Scanner(reader);
            Digraph digraph = new Digraph(scanner);
            System.out.println(digraph);

            int[] linear = sort(digraph);
            System.out.println(Arrays.toString(linear)); // [8, 9, 1, 0, 2, 3, 4, 5, 10, 11, 6, 7, 12, 13]

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] sort(Digraph graph) {

        boolean[] visited = new boolean[graph.V()];
        Deque<Integer> stack = new LinkedList<>();

        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) {
                dfs(graph, v, visited, stack);
            }
        }

        int[] result = new int[graph.V()];
        int ind = 0;
        while (!stack.isEmpty()) {
            result[ind++] = stack.pop();
        }

        return result;
    }

    private static void dfs(Digraph graph, int start, boolean[] visited, Deque<Integer> stack) {
        visited[start] = true;

        for (int v : graph.adj(start)) {
            if (!visited[v]) {
                dfs(graph, v, visited, stack);
            }
        }

        stack.push(start);
    }

}
