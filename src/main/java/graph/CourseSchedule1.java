package graph;

public class CourseSchedule1 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        return false;
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