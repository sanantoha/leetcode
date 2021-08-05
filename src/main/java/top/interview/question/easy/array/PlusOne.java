package top.interview.question.easy.array;

import java.util.Arrays;

class Solution6 {
    public int[] plusOne(int[] digits) {
        boolean breakCond = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i] + 1;
            if (v < 10) {
                digits[i] = v;
                breakCond = true;
                break;
            } else {
                digits[i] = v % 10;
            }
        }
        if (breakCond) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            int j = 1;
            for (int i = 0; i < digits.length; i++) {
                res[j++] = digits[i];
            }
            return res;
        }
    }
}

public class PlusOne {
    public static void main(String[] args) {
        Solution6 s = new Solution6();

        int[] arr = {8,9,9,9};

        System.out.println(Arrays.toString(s.plusOne(arr)));
    }
}
