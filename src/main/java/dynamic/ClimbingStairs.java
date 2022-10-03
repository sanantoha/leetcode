package dynamic;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs {

    // O(n) time | O(n) space
    public static int climbStairsDP(int n) {
        if (n <= 0) return 0;

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        return ways[n];
    }

    public static int climbStairs(int n) {
        if (n <= 0) return 0;

        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(climbStairsDP(0) == 0);
        System.out.println(climbStairsDP(1) == 1);
        System.out.println(climbStairsDP(2) == 2);
        System.out.println(climbStairsDP(3) == 3);
        System.out.println(climbStairsDP(4) == 5);
        System.out.println(climbStairsDP(5) == 8);

        System.out.println("=======================");

        System.out.println(climbStairs(0) == 0);
        System.out.println(climbStairs(1) == 1);
        System.out.println(climbStairs(2) == 2);
        System.out.println(climbStairs(3) == 3);
        System.out.println(climbStairs(4) == 5);
        System.out.println(climbStairs(5) == 8);
    }
}
