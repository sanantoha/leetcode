package dynamic;

public class StaircaseTraversal10 {

    public static int staircaseTraversalRec(int height, int maxSteps) {
        return -1;
    }

    public static int staircaseTraversalRecMemoization(int height, int maxSteps) {
        return -1;
    }

    public static int staircaseTraversalIter(int height, int maxSteps) {
        return -1;
    }

    public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversalRec(4, 2));
        System.out.println(staircaseTraversalRec(4, 3));
        System.out.println("==============================================");
        System.out.println(staircaseTraversalRecMemoization(4, 2));
        System.out.println(staircaseTraversalRecMemoization(4, 3));
        System.out.println("==============================================");
        System.out.println(staircaseTraversalIter(4, 2));
        System.out.println(staircaseTraversalIter(4, 3));
        System.out.println("==============================================");
        System.out.println(staircaseTraversalSlidingWindow(4, 2));
        System.out.println(staircaseTraversalSlidingWindow(4, 3));
    }
}
