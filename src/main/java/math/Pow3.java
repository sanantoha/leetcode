package math;

public class Pow3 {

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return pow(1 / x, -n);
        if (n % 2 == 0) {
            double y = pow(x, n / 2);
            return y * y;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 2));
    }
}
