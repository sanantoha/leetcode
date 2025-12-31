package graph;

import java.util.*;

public class CourseSchedule {

    // O(E + V) time | O(V) space
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<Integer>[] adjList = createAdjList(numCourses, prerequisites);

        int[] visited = new int[numCourses];
        for (int v = 0; v < numCourses; v++) {
            if (visited[v] == 0) {
                if (canNotFinishDfs(adjList, visited, v)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canNotFinishDfs(List<Integer>[] adjList, int[] visited, int v) {
        visited[v] = 1;

        for (int u : adjList[v]) {
            if (visited[u] == 1) {
                return true;
            }
            if (visited[u] == 0) {
                if (canNotFinishDfs(adjList, visited, u)) {
                    return true;
                }
            }
        }

        visited[v] = 2;
        return false;
    }

    // O(E + V) time | O(V) space
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        List<Integer>[] adjList = createAdjList(numCourses, prerequisites);
        int[] cnt = new int[numCourses];

        for (int v = 0; v < numCourses; v++) {
            for (int u : adjList[v]) {
                cnt[u]++;
            }
        }

        boolean isCircle = true;
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < cnt.length; v++) {
            if (cnt[v] == 0) {
                isCircle = false;
                queue.add(v);
            }
        }

        if (isCircle) {
            return false;
        }

        int idx = 0;

        while (!queue.isEmpty()) {
            int v = queue.remove();

            idx++;

            for (int u : adjList[v]) {
                cnt[u]--;

                if (cnt[u] == 0) {
                    queue.add(u);
                }
            }
        }

        if (idx != numCourses) {
            return false;
        }

        return true;
    }

    private static List<Integer>[] createAdjList(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for (int v = 0; v < numCourses; v++) {
            adjList[v] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            List<Integer> lst = adjList[p[0]];
            lst.add(p[1]);
        }

        return adjList;
    }

    static void main() {
        System.out.println(
                canFinish(1, new int[][] {})
        );

        System.out.println(
                canFinish(2, new int[][] {
                        {1, 0}
                })
        );

        System.out.println(
                !canFinish(2, new int[][] {
                        {1, 0},
                        {0, 1}
                })
        );

        System.out.println(
                !canFinish(4, new int[][] {
                        {1, 0},
                        {2, 1},
                        {3, 2},
                        {0, 3},
                })
        );

        System.out.println(
                canFinish(4, new int[][] {
                        {1, 0},
                        {2, 1},
                        {3, 2},
                })
        );

        System.out.println("=====================================================");

        System.out.println(
                canFinish1(1, new int[][] {})
        );

        System.out.println(
                canFinish1(2, new int[][] {
                        {1, 0}
                })
        );

        System.out.println(
                !canFinish1(2, new int[][] {
                        {1, 0},
                        {0, 1}
                })
        );

        System.out.println(
                !canFinish1(4, new int[][] {
                        {1, 0},
                        {2, 1},
                        {3, 2},
                        {0, 3},
                })
        );

        System.out.println(
                canFinish1(4, new int[][] {
                        {1, 0},
                        {2, 1},
                        {3, 2},
                })
        );
    }
}