package dynamic;

public class StaircaseTraversal3 {

    public static int staircaseTraversalRec(int height, int maxSteps) {
        if (height <= 1) return 1;

        int sum = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            sum += staircaseTraversalRec(height - i, maxSteps);
        }
        return sum;
    }

    public static int staircaseTraversalRecMemoization(int height, int maxSteps) {
        int[] memoiz = new int[height + 1];
        memoiz[0] = 1;
        return staircaseTraversalRecMemoization(height, maxSteps, memoiz);
    }

    public static int staircaseTraversalRecMemoization(int height, int maxSteps, int[] memoiz) {
        if (memoiz[height] > 0) return memoiz[height];

        int sum = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            sum += staircaseTraversalRecMemoization(height - i, maxSteps, memoiz);
        }
        memoiz[height] = sum;
        return sum;
    }

    public static int staircaseTraversalIter(int height, int maxSteps) {
        if (height <= 1) return 1;

        int[] dp = new int[height + 1];
        dp[0] = 1;

        for (int i = 1; i <= height; i++) {
            int step = 1;
            while (step <= maxSteps && step <= i) {
                dp[i] += dp[i - step];
                step++;
            }
        }
        return dp[height];
    }

    public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
        int[] wayToTaps = new int[height + 1];
        wayToTaps[0] = 1;

        int sum = 0;
        for (int i = 1; i <= height; i++) { // 1 2 3 4 5
            int startOfWindow = i - maxSteps - 1;
            int endOfWindow = i - 1;
            if (startOfWindow >= 0) {
                sum -= wayToTaps[startOfWindow];
            }
            sum += wayToTaps[endOfWindow];
            wayToTaps[i] = sum;
        }
        return sum;
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
