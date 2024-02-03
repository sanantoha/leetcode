package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TopologicalSort1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/digraph.txt")) {
            Scanner scanner = new Scanner(reader);

            Digraph graph = new Digraph(scanner);
            System.out.println(graph);

            int[] linear = sort(graph);
            int[] linear1 = sort1(graph);
            // [8, 9, 1, 0, 2, 3, 4, 5, 10, 11, 6, 7, 12, 13]
            System.out.println(Arrays.toString(linear));
            // [0, 1, 8, 2, 9, 4, 3, 5, 6, 10, 7, 11, 12, 13]
            System.out.println(Arrays.toString(linear1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] sort1(Digraph graph) {
        return null;
    }

    private static int[] sort(Digraph graph) {
        return null;
    }
}
