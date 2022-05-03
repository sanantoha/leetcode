package dynamic;

import java.util.List;

public class LongestIncrSubseq4 {

    public static int lis0(int[] arr) {
        return -1;
    }

    public static int lis(int[] arr) {
        return -1;
    }

    public static List<Integer> lisList0(int[] arr) {
        return null;
    }

    public static List<Integer> lisList(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr0 = {1, 2, 3, 6, -100, -90, -80, -70, -60, 7, 8, 9, 10, -50, -40};
        System.out.println(lis0(arr0));
        System.out.println(lis(arr0));
        System.out.println(lisList(arr0)); // 9
        System.out.println(lisList0(arr0)); // 9
        System.out.println("==============================");

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        System.out.println(lis(arr));
        System.out.println(lis(arr));
        System.out.println(lis0(arr));
        System.out.println(lisList(arr)); // 6
        System.out.println(lisList0(arr)); // 6
        System.out.println("==============================");

        //           1  2 1 1 2 3
        int[] arr1 = {4,10,4,3,8,9}; // 3
        System.out.println(lis(arr1));
        System.out.println(lis0(arr1));
        System.out.println(lisList(arr1));
        System.out.println(lisList0(arr1));
        System.out.println("==============================");
//////
        int[] arr2 = {10,9,2,5,3,7,101,18}; // 4
        System.out.println(lis(arr2));
        System.out.println(lis0(arr2));
        System.out.println(lisList(arr2));
        System.out.println(lisList0(arr2));

        System.out.println("===============================");
//
        int[] arr3 = {1, -10, 20, 30, 2, 3, 4, 5}; // 5
        System.out.println(lis(arr3));
        System.out.println(lis0(arr3));
        System.out.println(lisList(arr3));
        System.out.println(lisList0(arr3));
    }
}
