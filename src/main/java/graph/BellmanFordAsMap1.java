package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static graph.GraphUtils.edgeWeightedDigraph;
import static graph.GraphUtils.printEdgeWeightedDigraph;

public class BellmanFordAsMap1 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
