package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortDFSCycleGraphAsMap2 {

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
