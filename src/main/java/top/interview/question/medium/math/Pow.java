package top.interview.question.medium.math;

class Solution3 {
    public double myPow(double x, int n) {
        return myPowLong(x, n);
    }

    private double myPowLong(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return myPowLong(1 / x, -n);
        if (n % 2 == 0) {
            double y = myPowLong(x, n / 2);
            return y * y;
        } else return x * myPowLong(x, n - 1);
    }

    private double myPowLong0(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return myPowLong0(1 / x, -n);
        double result = myPowLong0(x * x, n / 2);
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }
}

public class Pow {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.myPow(2, 10));

        System.out.println(s.myPow(2.1, 3));

        System.out.println(s.myPow(2.0, -2));


        System.out.println(s.myPow(2.0, Integer.MAX_VALUE));

        System.out.println(s.myPow(1, Integer.MIN_VALUE));

//        System.out.println(Math.pow(-1, Integer.MIN_VALUE));

//        Integer.MIN_VALUE
    }
}
