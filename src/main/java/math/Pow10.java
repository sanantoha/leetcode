package math;

public class Pow10 {

    // O(log(n)) time | O(log(n)) space
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return pow(1 / x, -n);
        if (n % 2 == 0) {
            double y = pow(x, n / 2);
            return y * y;
        }
        return x * pow(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(pow(4, 2));
        System.out.println(pow(2, 4));
        System.out.println(pow(2.1, 3));
        System.out.println(Math.pow(2.1, 3));
    }
}
