package strings;

public class ReverseInteger1 {

    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));

        System.out.println(reverse(0));

        System.out.println(reverse(-123));

        System.out.println(reverse(120));
    }
}
