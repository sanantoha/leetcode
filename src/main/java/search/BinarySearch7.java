package search;

public class BinarySearch7 {

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return (arr[l] == target) ? l : -(l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println(binarySearch(arr, 80));
    }
}
