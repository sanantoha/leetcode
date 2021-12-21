package search;

public class SearchInRotatedSortedArray9 {

    public static int search(int[] arr, int target) {
        return -1;
    }

    public static int search1(int[] arr, int target) {
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,2, 4,5,6,7, 8};
        int[] arr = {40, 50, 60, 70, 80, 90, 0, 10, 20, 30, 31, 32, 33, 34, 35};
        int target = 35;

//        System.out.println(findSmallestIdx(arr));
        System.out.println(search(arr, target));
        System.out.println(search1(arr, target));
    }
}
