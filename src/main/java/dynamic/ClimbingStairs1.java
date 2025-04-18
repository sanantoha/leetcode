package dynamic;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs1 {

    public static int climbStairsDP(int n) {
        return -1;
    }

    public static int climbStairs(int n) {
        return -1;
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
