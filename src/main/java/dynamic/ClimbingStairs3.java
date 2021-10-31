package dynamic;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs3 {

    // O(n) time | O(n) space
    public static int climbStairsDP(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    // O(n) time | O(1) space
    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int x = 1;
        int y = 2;

        for (int i = 3; i < n + 1; i++) {
            int tmp = x;
            x = y;
            y = tmp + y;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(climbStairsDP(0));
        System.out.println(climbStairsDP(1));
        System.out.println(climbStairsDP(2));
        System.out.println(climbStairsDP(3));
        System.out.println(climbStairsDP(4));
        System.out.println(climbStairsDP(5));

        System.out.println("=======================");

        System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }
}
