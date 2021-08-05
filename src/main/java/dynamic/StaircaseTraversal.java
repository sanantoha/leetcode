package dynamic;

public class StaircaseTraversal {

    // O(maxSteps ^ height) time | O(height) space
    public static int staircaseTraversalRec(int height, int maxSteps) {
        if (height < 1) return 1;

        int sum = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            sum += staircaseTraversalRec(height - i, maxSteps);
        }
        return sum;
    }

    // O(height * maxSteps) time | O(height) space
    public static int staircaseTraversalRecMemoization(int height, int maxSteps) {
        int[] memoiz = new int[height + 1];
        memoiz[0] = 1;
        memoiz[1] = 1;
        return starcaseTraversalRecMemoizationRec(height, maxSteps, memoiz);
    }

    private static int starcaseTraversalRecMemoizationRec(int height, int maxSteps, int[] memoiz) {
        if (memoiz[height] > 0) return memoiz[height];

        int sum = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            sum += starcaseTraversalRecMemoizationRec(height - i, maxSteps, memoiz);
        }
        memoiz[height] = sum;
        return sum;
    }

    // O(height * maxSteps) time | O(height) space
    public static int staircaseTraversalIter(int height, int maxSteps) {
        int[] dp = new int[height + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= height; i++) {
            int step = 1;
            while (step <= maxSteps && step <= i) {
                dp[i] += dp[i - step];
                step++;
            }
        }
        return dp[height];
    }

    // O(height) time | O(height) space
    public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;

        int sum = 0;
        for (int i = 1; i <= height; i++) {
            int startWindow = i - maxSteps - 1;
            int endWindow = i - 1;
            if (startWindow >= 0) {
                sum -= waysToTop[startWindow];
            }
            sum += waysToTop[endWindow];
            waysToTop[i] = sum;
        }
        return  waysToTop[height];
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversalRec(4, 2));
        System.out.println(staircaseTraversalRec(4, 3));

        System.out.println(staircaseTraversalRecMemoization(4, 2));
        System.out.println(staircaseTraversalRecMemoization(4, 3));

        System.out.println(staircaseTraversalIter(4, 2));
        System.out.println(staircaseTraversalIter(4, 3));

        System.out.println(staircaseTraversalSlidingWindow(4, 2));
        System.out.println(staircaseTraversalSlidingWindow(4, 3));
    }
}
