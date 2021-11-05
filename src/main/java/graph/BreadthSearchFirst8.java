package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BreadthSearchFirst8 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bfs.txt")) {
            Scanner scanner = new Scanner(reader);
            EdgeWeightedDigraph graph = new EdgeWeightedDigraph(scanner);
            System.out.println(graph);

            List<Integer> res = bfs(graph, 0);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> bfs(EdgeWeightedDigraph graph, int start) {
        return null;
    }
}
