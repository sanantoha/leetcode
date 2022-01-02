package dynamic;

import java.util.List;

public class LongestDecrSubseq2 {

    public static int lds(int[] arr) {
        return -1;
    }

    public static List<Integer> ldsList(int[] arr) {
        return null;
    }

    public static int lds1(int[] arr) {
        return -1;
    }

    public static List<Integer> ldsList1(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,6,5,4,3,10,14,12};

        System.out.println(lds(arr));
        System.out.println(lds1(arr));
        System.out.println(ldsList(arr));
        System.out.println(ldsList1(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(lds1(arr1));
        System.out.println(ldsList(arr1));
        System.out.println(ldsList1(arr1));
    }
}
