package math;

public class Pow {

    // O(log(n)) time | O(1) space
    public static double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return power(1 / x, -n);

        if (n % 2 == 0) {
            double res = power(x, n / 2);
            return res * res;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));

        System.out.println(power(2.1, 3));

        System.out.println(power(2.0, -2));
    }
}
