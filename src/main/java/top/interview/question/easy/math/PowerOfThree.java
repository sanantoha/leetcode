package top.interview.question.easy.math;

class Solution2 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        double x = Math.log10(n) / Math.log10(3);
        return x % 1 == 0;
    }
}

public class PowerOfThree {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.isPowerOfThree(1594322));


    }
}
