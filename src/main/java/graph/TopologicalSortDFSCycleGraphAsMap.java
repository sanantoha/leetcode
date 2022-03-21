package graph;

import java.util.*;

public class TopologicalSortDFSCycleGraphAsMap {

    // O(E + V) time | O(V) space
    public static List<String> sort(Map<String, List<String>> graph) {
        if (graph == null || graph.isEmpty()) return Collections.emptyList();

        Map<String, Integer> visited = new HashMap();
        Deque<String> stack = new LinkedList<>();

        for (String v : graph.keySet()) {
            dfs(graph, visited, v, stack);
        }

        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void dfs(Map<String, List<String>> graph, Map<String, Integer> visited, String v, Deque<String> stack) {
        if (visited.getOrDefault(v, 0) != 0) return;
        visited.put(v, 1);

        for (String u : graph.getOrDefault(v, Collections.emptyList())) {
            if (visited.getOrDefault(u, 0) == 1) {
                throw new IllegalStateException("cycle in graph vertex: " + v);
            }
            if (visited.getOrDefault(u, 0) == 0) {
                dfs(graph, visited, u, stack);
            }
        }

        visited.put(v, 2);
        stack.push(v);
    }


    // O(E + V) time | O(V) space
    public static List<String> sortIter(Map<String, List<String>> graph) {

        Map<String, Integer> cnt = new HashMap<>();
        for (String v : graph.keySet()) {
            cnt.put(v, 0);
        }

        for (String v : graph.keySet()) {
            for (String u : graph.getOrDefault(v, Collections.emptyList())) {
                var count = cnt.getOrDefault(u, 0);
                cnt.put(u, count + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();

        boolean isCycle = true;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            String v = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                queue.add(v);
                isCycle = false;
            }
        }

        if (isCycle) throw new IllegalStateException("cycle in graph");

        List<String> res = new ArrayList<>();

        int idx = 0;
        while (!queue.isEmpty()) {
            String v = queue.remove();
            res.add(v);
            idx++;

            for (String u : graph.getOrDefault(v, Collections.emptyList())) {
                var count = cnt.getOrDefault(u, 0);
                count--;
                cnt.put(u, count);
                if (count == 0) {
                    queue.add(u);
                }
            }
        }

        if (idx != graph.size()) throw new IllegalStateException("cycle in graph");

        return res;
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
