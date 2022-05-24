package dynamic;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs1 {

    // O(n) time | O(n) space
    public static int climbStairsDP(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }

        return ways[n];
    }

    // O(n) time | O(1)
    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int fst = 1;
        int snd = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = fst + snd;
            fst = snd;
            snd = tmp;
        }
        return snd;
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
