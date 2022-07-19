package dynamic;

import java.util.List;

public class LongestNonDecrSubseq1 {

    public static int lnds(int[] arr) {
        return -1;
    }

    public static List<Integer> lndsList(int[] arr) {
        return null;
    }

    public static int lnds1(int[] arr) {
        return -1;
    }

    public static List<Integer> lndsList1(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,2, 3,4,5,2,2,2,2, 3}; // 8

//        int[] arr = {-1, 3, 4, 5, 2, 2, 2, 2}; // 5

        System.out.println(lnds(arr));
        System.out.println(lnds1(arr));
        System.out.println(lndsList(arr));
        System.out.println(lndsList1(arr));
    }
}
