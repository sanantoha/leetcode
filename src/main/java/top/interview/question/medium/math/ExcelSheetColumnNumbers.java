package top.interview.question.medium.math;

public class ExcelSheetColumnNumbers {

    public static int titleToNumber(String columnTitle) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            res *= 26;
            res += letters.indexOf(columnTitle.charAt(i)) + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));

        System.out.println(titleToNumber("AB"));

        System.out.println(titleToNumber("ZY"));

        System.out.println(titleToNumber("FXSHRXW"));
    }
}
