package top.interview.question.easy.dynamic;


class Solution0 {

    public int climbStairs0(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

public class ClimbingStairs {

    public static void main(String[] args) {
        Solution0 s = new Solution0();

        System.out.println(s.climbStairs(2));

        System.out.println(s.climbStairs(3));

        System.out.println(s.climbStairs(4));


        System.out.println(s.climbStairs(6));
        System.out.println(s.climbStairs(7));
        System.out.println(s.climbStairs(8));
    }
}
