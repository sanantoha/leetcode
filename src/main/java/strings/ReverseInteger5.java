package strings;

public class ReverseInteger5 {

    // O(n) time | O(1) space
    public static int reverse(int n) {
        long res = 0;
        int k = n;
        while (k != 0) {
            res = res * 10 + k % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return -1;
            k /= 10;
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
