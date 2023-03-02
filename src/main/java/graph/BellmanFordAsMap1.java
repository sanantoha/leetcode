package graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static graph.GraphUtils.edgeWeightedDigraph;
import static graph.GraphUtils.printEdgeWeightedDigraph;
import static graph.GraphUtils.Pair;
import static graph.GraphUtils.Edge;

public class BellmanFordAsMap1 {

    // Pair{t1={0=-35.0, 1=-46.0, 2=-44.0, 3=-28.0, 4=-37.0}, t2={0=4, 1=2, 2=4, 3=0, 4=1}}
    // [1, 2, 4]
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/main/java/graph/bellmanFord.txt")) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
