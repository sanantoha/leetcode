package strings;

public class ReverseInteger3 {

    // O(1) time | O(1) space because integer length is max 32
    public static int reverse(int n) {
        long res = 0;
        while (n != 0) {
            res = 10 * res + n % 10;
            if (res > Integer.MAX_VALUE) return -1;
            n /= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));

        System.out.println(reverse(0));

        System.out.println(reverse(-123));

        System.out.println(reverse(120));
    }
}
