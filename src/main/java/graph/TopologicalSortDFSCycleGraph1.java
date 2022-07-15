package graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortDFSCycleGraph1 {

    public static int[] sort(Digraph graph) {
        return null;
    }

    public static int[] sortIter(Digraph graph) {
        return null;
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 0);

        System.out.println(graph);

        System.out.println(Arrays.toString(sort(graph)));
        System.out.println(Arrays.toString(sortIter(graph)));
    }
}
