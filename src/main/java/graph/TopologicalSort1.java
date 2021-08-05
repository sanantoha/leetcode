package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TopologicalSort1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/digraph.txt")) {
            Scanner scanner = new Scanner(reader);

            Digraph graph = new Digraph(scanner);
            System.out.println(graph);

            int[] linear = sort(graph);
            // [8, 9, 1, 0, 2, 3, 4, 5, 10, 11, 6, 7, 12, 13]
            System.out.println(Arrays.toString(linear));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] sort(Digraph graph) {

        int[] inDegree = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            for (int u : graph.adj(v)) {
                inDegree[u]++;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int u = 0; u < inDegree.length; u++) {
            if (inDegree[u] == 0) {
                stack.push(u);
            }
        }

        int index = 0;
        int[] linear = new int[graph.V()];
        while(!stack.isEmpty()) {
            int v = stack.pop();
            linear[index++] = v;
            for (int u : graph.adj(v)) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    stack.push(u);
                }
            }
        }

        if (index != graph.V()) {
            throw new IllegalStateException("Graph has a cycle");
        }
        return linear;
    }
}
