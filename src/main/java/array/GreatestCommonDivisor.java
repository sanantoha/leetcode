package array;

public class GreatestCommonDivisor {

    // O(log(x + y)) time | O(1) space
    public static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }

    public static void main(String[] args) {
        System.out.println(gcd(18, 6) == 6);

        System.out.println(gcd(18, 10) == 2);

        System.out.println(gcd(17, 11) == 1);

        System.out.println(gcd(5, 15) == 5);

        System.out.println(gcd(2, 3));
    }
}
