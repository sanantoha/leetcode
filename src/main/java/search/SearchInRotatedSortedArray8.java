package search;

public class SearchInRotatedSortedArray8 {

    // O(log(n)) time | O(1) space
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int smallest = findSmallestIdx(arr);

        int l = 0;
        int r = arr.length - 1;

        if (target > arr[smallest] && target <= arr[r]) {
            l = smallest;
        } else {
            r = smallest - 1;
        }

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target == arr[mid]) return mid;
            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int findSmallestIdx(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= arr[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // O(log(n)) time | O(1) space
    public static int search1(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            if (arr[mid] == target) return mid;

            if (arr[mid] <= arr[r]) { // right sorted
                if (target > arr[mid] && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // left sorted
                if (target < arr[mid] && target >= arr[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,2, 4,5,6,7, 8};
        int[] arr = {40, 50, 60, 70, 80, 90, 0, 10, 20, 30, 31, 32, 33, 34, 35};
        int target = 90;

//        System.out.println(findSmallestIdx(arr));
        System.out.println(search(arr, target));
        System.out.println(search1(arr, target));
    }
}
