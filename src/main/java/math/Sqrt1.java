package math;

public class Sqrt1 {

    public static int sqrt(int x) {
        if (x < 0) return -1;

        long l = 0;
        long r = x;

        while (l <= r) {
            long mid = (l + r) >>> 1;
            if (mid * mid <= x) l = mid + 1;
            else r = mid - 1;
        }
        return (int) (l - 1);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(6));
        System.out.println(sqrt(7));
        System.out.println(sqrt(8));
        System.out.println(sqrt(16));

        System.out.println(Math.sqrt(7));
    }
}
