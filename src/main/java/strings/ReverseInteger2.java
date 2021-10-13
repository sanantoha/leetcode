package strings;

public class ReverseInteger2 {

    // O(1) time | O(1) space - because digit length is limited for int type
    public static int reverse(int n) {
        long res = 0;

        while (n != 0) {
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
            res = res * 10 + n % 10;
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
