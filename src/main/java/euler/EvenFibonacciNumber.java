package euler;

public class EvenFibonacciNumber {

    public static int fib(int a, int b, int n) {
        if (n <= 0) return a;
        else {
            return fib(b, a + b, n - 1);
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        int i = 0;
        while (true) {

            int v = fib(1, 2, i);
            if (v > 4_000_000) break;
            if (v % 2 == 0) {
                sum += v;
            }

            i++;
        }

        System.out.println(sum);
    }
}
