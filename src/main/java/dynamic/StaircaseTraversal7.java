package dynamic;

public class StaircaseTraversal7 {

    // O(maxSteps ^ height) time | O(height) space
    public static int staircaseTraversalRec(int height, int maxSteps) {
        if (height <= 1) return 1;

        int count = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            count += staircaseTraversalRec(height - i, maxSteps);
        }
        return count;
    }

    // O(maxSteps * height) time | O(height) space
    public static int staircaseTraversalRecMemoization(int height, int maxSteps) {
        if (height <= 1) return 1;
        int[] memoz = new int[height + 1];
        memoz[0] = 1;
        return staircaseTraversalRecMemoization(height, maxSteps, memoz);
    }

    public static int staircaseTraversalRecMemoization(int height, int maxSteps, int[] memoz) {
        if (memoz[height] > 0) return memoz[height];

        int count = 0;
        for (int i = 1; i <= Math.min(height, maxSteps); i++) {
            count += staircaseTraversalRecMemoization(height - i, maxSteps, memoz);
        }
        memoz[height] = count;
        return count;
    }

    // O(height * maxSteps) time | O(height) space
    public static int staircaseTraversalIter(int height, int maxSteps) {
        if (height <= 1) return 1;

        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;

        for (int i = 1; i <= height; i++) {
            int step = 1;
            while (step <= maxSteps && step <= i) {
                waysToTop[i] += waysToTop[i - step];
                step++;
            }
        }
        return waysToTop[height];
    }

    // O(height) time | O(height) space
    public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
        if (height <= 1) return 1;

        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;

        int sum = 0;
        for (int i = 1; i <= height; i++) {
            int startIdx = i - maxSteps - 1;
            if (startIdx >= 0) {
                sum -= waysToTop[startIdx];
            }
            sum += waysToTop[i - 1];
            waysToTop[i] = sum;
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
