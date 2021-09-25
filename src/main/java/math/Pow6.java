package math;

public class Pow6 {

    public static double pow(double x, int n) {
        if (n == 0) return 1d;
        else if (n == 1) return x;
        else if (n < 0) return pow(1 / x, -n);
        else if (n % 2 == 0) {
            double y = pow(x, n / 2);
            return y * y;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(4, 2));
        System.out.println(pow(2, 4));
        System.out.println(pow(2.1, 3));
        System.out.println(Math.pow(2.1, 3));
    }

}
