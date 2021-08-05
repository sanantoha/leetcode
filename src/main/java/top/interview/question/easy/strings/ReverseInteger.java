package top.interview.question.easy.strings;

class Solution1 {

    public long mcoef(int x) {
        long res = 1;
        int base = x / 10;
        while (base != 0) {
            base /= 10;
            res *= 10;
        }
        return res;
    }

    public int reverse(int x) {
        int base = x;
        int mod = 0;
        long res = 0;
        long k = mcoef(x);

        while (base != 0 || mod != 0) {
            mod = base % 10;
            res += k * mod;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            k /= 10;
            base /= 10;
        }
        return (int) res;
    }


}

public class ReverseInteger {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.reverse(-123));

        System.out.println(s.reverse(1534236469));
    }
}
