package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TopologicalSort {
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

    private static int[] sort(Digraph digraph) {

        int[] inDegree = new int[digraph.V()];

        for (int v = 0; v < digraph.V(); v++) {
            Iterable<Integer> adj = digraph.adj(v);
            for (Integer u : adj) {
                inDegree[u]++;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int v = 0; v < inDegree.length; v++) {
            if (inDegree[v] == 0) {
                stack.push(v);
            }
        }


        int[] result = new int[inDegree.length];
        int index = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            result[index++] = v;
            for (Integer u : digraph.adj(v)) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    stack.push(u);
                }
            }
        }

        if (index != digraph.V()) {
            throw new IllegalStateException("Graph has a cycle");
        }

        return result;
    }
}
