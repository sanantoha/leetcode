package top.interview.question.medium.other;

public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int x = a ^ b;
            int y = (a & b) << 1;
            a = x;
            b = y;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 3));
    }
}
