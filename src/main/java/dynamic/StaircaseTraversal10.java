package dynamic;

public class StaircaseTraversal10 {

    // O(maxSteps ^ height) time | O(height) space
    public static int staircaseTraversalRec(int height, int maxSteps) {
        if (height == 0) return 1;

        int count = 0;

        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            count += staircaseTraversalRec(height - i, maxSteps);
        }
        return count;
    }

    public static int staircaseTraversalRecMemoization(int height, int maxSteps) {
        int[] memo = new int[height + 1];
        memo[0] = 1;
        return staircaseTraversalRecMemoization(height, maxSteps, memo);
    }

    // O(maxSteps * height) time | O(height) space
    private static int staircaseTraversalRecMemoization(int height, int maxSteps, int[] memo) {
        if (memo[height] != 0) return memo[height];

        int count = 0;

        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            count += staircaseTraversalRecMemoization(height - i, maxSteps, memo);
        }
        memo[height] = count;
        return memo[height];
    }

    // O(maxSteps * height) time | O(n) space
    public static int staircaseTraversalIter(int height, int maxSteps) {
        if (height == 0) return 1;

        int[] ways = new int[height + 1];
        ways[0] = 1;

        for (int i = 1; i <= height; i++) {
            int step = 1;
            while (step <= maxSteps && step <= i) {
                ways[i] += ways[i - step];
                step++;
            }
        }
        return ways[height];
    }

    // O(height) time | O(height) space
    public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
        if (height == 0) return 1;

        int count = 0;
        int[] ways = new int[height + 1];
        ways[0] = 1;

        for (int i = 1; i <= height; i++) {
            int startWindowIdx = i - maxSteps - 1;
            int endIdx = i - 1;
            if (startWindowIdx >= 0) {
                count -= ways[startWindowIdx];
            }
            count += ways[endIdx];
            ways[i] = count;
        }
        return count;
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
