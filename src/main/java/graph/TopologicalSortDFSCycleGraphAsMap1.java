package graph;

import java.util.*;

public class TopologicalSortDFSCycleGraphAsMap1 {

    public static List<String> sort(Map<String, List<String>> graph) {
        return null;
    }

    public static List<String> sortIter(Map<String, List<String>> graph) {
        return null;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("B", "C", "D"));
        graph.put("B", List.of("C"));
        graph.put("C", List.of("D"));
//        graph.put("D", List.of("A", "B"));
        graph.put("D", Collections.emptyList());

        System.out.println(sort(graph));

        System.out.println(sortIter(graph));
    }
}
